package com.clyde.shopping.cart.logic;

import java.util.HashMap;

import com.clyde.shopping.cart.dao.ShoppingCart;
import com.clyde.shopping.cart.dao.ShoppingItem;

public class PurchaseLogic 
{
	private double total = 0;	// total purchase cost of cart items
	private double discountValue = 0; // the qualifying discount amount
	private int quantity = 0;
	private ShoppingCart cart;
	
	public PurchaseLogic(ShoppingCart cart, double discount)
	{
		this.cart = cart;
		this.discountValue = discount;
	}
	
	public void setDiscount(double discount)
	{
		this.discountValue = discount;
	}
	
	public double getDiscount()
	{
		return discountValue;
	}
	
	public void setCart(ShoppingCart cart)
	{
		this.cart = cart;
	}
	
	// calculate the cost of all items in the cart
	public double calculateTotalCost()
	{
		if(cart == null)
			return 0;
		
		HashMap<ShoppingItem, Integer> contents = cart.getCartContents();
		for(ShoppingItem item : contents.keySet())
		{
			quantity = contents.get(item);
			
			if(item.bulkDiscount)
			{
				if(quantity > 1)
					total += (item.cost * quantity) - ((item.cost * quantity) * (discountValue /100)); 
			}
			else
				total += item.cost * quantity; 
			
		}
		return total;
	}

}
