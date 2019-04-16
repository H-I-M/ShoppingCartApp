package com.clyde.shopping.cart.dao;

import java.util.HashMap;

// This class is the container of all the items in stock room and available for purchase. 
public class ShoppingCatalog
{
	private HashMap<ShoppingItem, Integer> catalog; // items in stock and their quantity 
	
	private ShoppingCatalog()
	{
		catalog = new HashMap<ShoppingItem, Integer>();
	}
	
	private static final ShoppingCatalog instance = new ShoppingCatalog();
	
	public static ShoppingCatalog getInstance()
	{
		return instance;
	}
	
	// get all items available on the catalog list
	public HashMap<ShoppingItem, Integer> getCatalogList()
	{
		if(catalog == null)
			return new HashMap<ShoppingItem, Integer>();
		else
			return catalog;
	}
	
	public void addCatalogItem(ShoppingItem item, int quantity)
	{
		if(item == null || quantity < 0)
			return;
		else
			catalog.put(item, quantity);
	}
	
	public void addCatalogItem(String name, double cost, boolean discountOnBulk, int quantity)
	{
		if((name == null || name.length() == 0 || name.equals(" ")) || cost <= 0 || quantity < 0)
			return;
		else
			catalog.put(new ShoppingItem(name, cost, discountOnBulk), quantity);
	}

}
