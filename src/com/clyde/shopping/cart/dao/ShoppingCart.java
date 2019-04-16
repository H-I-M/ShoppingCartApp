package com.clyde.shopping.cart.dao;

import java.util.HashMap;

// This ShoppingCart class is a simple container of shopping items.
public class ShoppingCart
{
	private HashMap<ShoppingItem, Integer> itemsList;	// the items in the cart
//	private int total = 0;	// total cost of cart so far
	
	public ShoppingCart()
	{
		itemsList = new HashMap<ShoppingItem, Integer>();
//		total = 0;
	}

	// Add a new item and update total amount
	public void addItem(ShoppingItem newItem)
	{
		// See if there's already an item like this in the cart, if not currently in cart add it. 
		int index = itemsList.get(newItem) == null ? -1 : itemsList.get(newItem);

		if (index == -1) 
		{
			itemsList.put(newItem, new Integer(1));
//			total += newItem.cost;
		} 
		else 
		{
			// If already in cart increase the quantity
			Integer quantity = itemsList.get(newItem);
			quantity = (++quantity);
			itemsList.replace(newItem, quantity);
//			total += newItem.cost;
		}

	}

// Removes shopping items from the cart
	public void removeItem(ShoppingItem oldItem)
	{
		int index = itemsList.get(oldItem) == null ? -1 : itemsList.get(oldItem);
	
		if (index == -1)
			return;
		else
		{
			Integer currentQuantity = itemsList.get(oldItem);
	
			if (currentQuantity <= 1)
			{
//				total -= oldItem.cost;
				itemsList.remove(oldItem);
			}
			else
			{
				itemsList.replace(oldItem, (--currentQuantity));
//				total -= oldItem.cost;
			}
		}
		
	}

	// returns all the items currently in the shopping cart
	public HashMap<ShoppingItem, Integer> getCartContents()
	{
		if(itemsList == null)
			return new HashMap<ShoppingItem, Integer>();
		else
			return itemsList;
	}
	
	public int getCartSize()
	{
		return itemsList.size();
	}
	
}
