package com.java.interview.RestaurantProj;

import java.util.List;

public class Snackble implements Runnable{

	private Category cat;
	boolean stop = false;
	List<Order> list ;
	public Snackble(String name,List<Order> list)
	{
		this.cat=RestaurantSimulator.catagory.get(name);
		this.list=list;
	}
	@Override
	public void run() {
		int total=0;
		for(Order o:list)
		{
			int round=0;
			stop=false;
			List<MenuItem> l = cat.getMenuItems();
			int minutes=0;
			for(MenuItem m : l)
			{
				if(m.getItemName().equals(o.getItemName()))
				{
					minutes=m.getMinutes();
				}
			}
			int qua=o.getQuantity();
			while(!stop)
			{
				if(qua<=cat.getNoChef())
				{
					round++;
					stop=true;
				}else
				{
					round++;
					qua=qua-cat.getNoChef();
				}
			}
			total=total+(round*minutes);
		}
		ProcessOrder.findMax.add(total);
		ProcessOrder.totalSize.getAndAdd(list.size());
	}
}
