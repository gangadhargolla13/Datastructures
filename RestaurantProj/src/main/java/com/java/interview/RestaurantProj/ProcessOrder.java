package com.java.interview.RestaurantProj;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessOrder{
	public static AtomicInteger totalSize;
	public static ArrayList<Integer> findMax;
	public OrderDetails details;
	private  CountDownLatch latch;
	public ProcessOrder(CountDownLatch latch)
	{
		this.latch=latch;
	}
	public void process(Queue<OrderDetails> queue)
	{
		while(!queue.isEmpty())
		{
			details = queue.peek();
			totalSize = new AtomicInteger();
			findMax = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		System.out.println(details.getCustomerName() +" order process is started at "+calendar.getTime().toString());
		List<Order> list = details.getOrderList();
		List<Order> sNames = new ArrayList<>();
		for (Order oo : list) {
			String itemName = oo.getItemName();
			switch (RestaurantSimulator.detailsMap.get(itemName)) {
			case "Veg":
				getRunnableObject("Veg",oo);
				break;
			case "Non-veg":
				getRunnableObject("Non-veg",oo);
				break;
			case "Juices":
				getRunnableObject("Juices",oo);
				break;
			case "Tea&coffee":
				getRunnableObject("Tea&coffee",oo);
				break;
			case "Snacks":
				sNames.add(oo);
				break;
			default:
				System.out.println("Nothing to process.");
				break;
			}
		}
		if (!sNames.isEmpty()) {
			Runnable s = new Snackble("Snacks",sNames);
			Thread st = new Thread(s);
			st.start();
		}
		while (list.size() != totalSize.get()) 
		{
			/*try
			{
				Thread.sleep(1000);
			}catch(Exception e)
			{
				
			}*/
		}
		int max = 0;
		for (Integer ii : findMax) {
			if (max < ii) {
				max = ii;
			}
		}
		calendar.add(Calendar.MINUTE, max);
		System.out.println(details.getCustomerName() +" order items all delivered at "+calendar.getTime().toString());
		latch.countDown();
		queue.remove();
		}
	}
	private void getRunnableObject(String categoty, Order oo) {
		Runnable jv = new NonSnacksble(categoty, oo);
		Thread t = new Thread(jv);
		t.start();
	}
}
