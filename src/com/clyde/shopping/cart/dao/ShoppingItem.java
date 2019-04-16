package com.clyde.shopping.cart.dao;

//This class depicts an individual shopping item

public class ShoppingItem implements Cloneable
{
	public String itemName;
	public double cost;
	public boolean bulkDiscount;

	public ShoppingItem()
	{
	}

	public ShoppingItem(String itemName, double cost, boolean discount)
	{
		this.itemName = itemName;
		this.cost = cost;
		this.bulkDiscount = discount;
	}

	public int hashCode()
	{
		return itemName.hashCode() + (int)cost;
	}

	public boolean equals(ShoppingItem otherItem)
	{
		if (this == otherItem) 
			return true;

		if (otherItem == null)
			return false;

		return (itemName.equals(otherItem.itemName)) &&	(cost == otherItem.cost);
	}

	//Create a copy of THIS object
	public ShoppingItem copy()
	{
		return new ShoppingItem(itemName, cost, bulkDiscount);
	}

	//Creates a String printable version of this object for displaying 
	public String toString()
	{
		return itemName+" cost: "+ cost + " bulk special: " + bulkDiscount;
	}
	
}
