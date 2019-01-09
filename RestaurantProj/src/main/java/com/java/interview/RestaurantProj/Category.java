package com.java.interview.RestaurantProj;

import java.util.List;

public class Category {

	private int noChef;
	private String categoryName;
	private List<MenuItem> menuItems;
	public Category(String categoryName)
	{
		this.categoryName = categoryName;
	}
	public int getNoChef() {
		return noChef;
	}
	public void setNoChef(int noChef) {
		this.noChef = noChef;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
