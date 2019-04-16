package com.clyde.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.clyde.shopping.cart.dao.ShoppingCart;
import com.clyde.shopping.cart.dao.ShoppingCatalog;
import com.clyde.shopping.cart.dao.ShoppingItem;
import com.clyde.shopping.cart.data.LoadCatalogData;
import com.clyde.shopping.cart.logic.PurchaseLogic;
import com.clyde.shopping.cart.logic.Validator;

public class Shopping 
{
	public static void main(String[] args)
	{
		new LoadCatalogData();
		Set<ShoppingItem> catalog = ShoppingCatalog.getInstance().getCatalogList().keySet();
		List<ShoppingItem> listCatalog = new ArrayList<ShoppingItem>(catalog);
		ShoppingCart cart = new ShoppingCart();
		Validator validator = new Validator();
		int displayId = 0;
		int selection = -1;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to XYZ online super market...");
		System.out.println("The following items are available for purchase : ");
		
		for(ShoppingItem item : listCatalog)
		{
			System.out.println((++displayId) + ")  " + item.itemName + " price: " + item.cost + " on promotion: " + (item.bulkDiscount ? "Yes" : "No"));
		}
		
		do
		{
			System.out.println();
			System.out.println("Please make your selection using the number identifing each item (1, 2, 3) followed by 'Enter', or 0 to checkout... ");
			selection = scan.nextInt();
			System.out.println();
			
			while(!validator.isValidInput(selection))
			{
				System.out.println("There is no item by that ID on our list, please make your selection using the number identifing each item (1, 2, 3) followed by 'Enter', or 0 to checkout... ");
				selection = scan.nextInt();
			}
				
			while(!validator.isSelectionValid(selection, catalog))
			{
				System.out.println("That item is not on our list. Please make your selection based on the provided list above followed by 'Enter', or 0 to checkout... ");
				selection = scan.nextInt();
			}
			
			if(selection == 0)
				break;
			
			cart.addItem(listCatalog.get(selection - 1));  // decrement the selection value to facilitate for Array index starting at 0.
		}
		while(selection != 0);
		
		if(selection == 0)
		{
			PurchaseLogic pl =  new PurchaseLogic(cart, 10);
			System.out.println();
			System.out.println("The total cost of all your selected purchase items is =  R" + pl.calculateTotalCost());
			System.out.println();
			System.out.println("Thank your for shopping with us, please come again soon ! ");
			System.exit(0);
		}
	}

}
