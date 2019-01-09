package com.java.interview.RestaurantProj;

import java.util.List;

public class NonSnacksble implements Runnable{

	private int qua;
	private Category cat;
	boolean stop = false;
	private String name;
	public NonSnacksble(String cat,Order oo)
	{
		this.qua=oo.getQuantity();
		this.cat=RestaurantSimulator.catagory.get(cat);
		this.name=oo.getItemName();
	}
	@Override
	public void run() {
		List<MenuItem> l = cat.getMenuItems();
		int minutes=0;
		for(MenuItem m : l)
		{
			if(m.getItemName().equals(name))
			{
				minutes=m.getMinutes();
			}
		}
		int val =0;
		while(!stop)
		{
			if(qua<=cat.getNoChef())
			{
				val+=minutes;
				stop=true;
			}else
			{
				qua=qua-cat.getNoChef();
				val+=minutes;
			}
		}
		ProcessOrder.totalSize.getAndIncrement();
		ProcessOrder.findMax.add(val);
	}
}
