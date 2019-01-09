package com.java.interview.RestaurantProj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class RestaurantSimulator {

	public final static Map<String, String> detailsMap = new ConcurrentHashMap<>();
	public final static Map<String, Category> catagory = new ConcurrentHashMap<>();
	private final static Category[] categories = new Category[5];
	static {
		Category veg = new Category("Veg");
		Category nonVeg = new Category("Non-veg");
		Category juices = new Category("Juices");
		Category teaCoffee = new Category("Tea&coffee");
		Category snacks = new Category("Snacks");

		categories[0] = veg;
		categories[1] = nonVeg;
		categories[2] = juices;
		categories[3] = teaCoffee;
		categories[4] = snacks;

		catagory.put("Veg", veg);
		catagory.put("Non-veg", nonVeg);
		catagory.put("Juices", juices);
		catagory.put("Tea&coffee", teaCoffee);
		catagory.put("Snacks", snacks);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (Category category : categories) {
			System.out.println("Enter number of chef in " + category.getCategoryName() + " catagory.");
			category.setNoChef(sc.nextInt());
		}
         System.out.println("============================");
         System.out.println("Please provide item name and time takes to finish as Bhiryani/10");
         System.out.println("=============================");
		for (Category category : categories) {
			System.out.println("Enter number of items in " + category.getCategoryName() + " catagory.");
			int noOfItem = sc.nextInt();
			List<MenuItem> menuItems = new ArrayList<>();
			for (int i = 0; i < noOfItem; i++) {
				System.out.println("Enter item name and its time period to prpare");
				String inline = sc.next();
				String[] iStr = inline.split("/");
				MenuItem item = new MenuItem();
				detailsMap.put(iStr[0], category.getCategoryName());
				item.setItemName(iStr[0]);
				item.setMinutes(Integer.parseInt(iStr[1]));
				menuItems.add(item);
			}
			category.setMenuItems(menuItems);
		}
		System.out.println("Enter number of orders");
		int count = sc.nextInt();
		final CountDownLatch latch = new CountDownLatch(count);
		 System.out.println("######################################");
         System.out.println("Order items like item name and quantity as Fish-fry/8");
         System.out.println("######################################");
         Queue<OrderDetails> queue = new LinkedList<>();
		for (int j = 0; j < count; j++) {
			System.out.println("Enter customerName");
			String name = sc.next();
			OrderDetails od = new OrderDetails();
			od.setCustomerName(name);
			od.setOrderList(new ArrayList<Order>());
			System.out.println("Enter number of items you want to order.");
			int qua = sc.nextInt();
			for (int i = 0; i < qua; i++) {
				String o = sc.next();
				String[] oa = o.split("/");
				od.getOrderList().add(new Order(oa[0], Integer.parseInt(oa[1])));
			}
			queue.add(od);
			System.out.println(name +"order is taken successfully.");
		}
		sc.close();
			ProcessOrder process = new ProcessOrder(latch);
			process.process(queue);
		try {
			latch.await();
			System.out.println("All orders are completed");
		} catch (Exception e) {

		}
	}
}
