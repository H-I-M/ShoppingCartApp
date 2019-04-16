package com.clyde.shopping.cart.data;

import com.clyde.shopping.cart.dao.ShoppingCatalog;

// This class acts as a data loader for the catalog, giving some basic items for selection
// in a bigger system this would be replaced by a better way of loading stock inventory. 
public class LoadCatalogData
{
	public LoadCatalogData()
	{
		ShoppingCatalog catalog = ShoppingCatalog.getInstance();
		catalog.addCatalogItem("Bread", 10, true, 5);
		catalog.addCatalogItem("Beans", 5.5, false, 10);
		catalog.addCatalogItem("Milk", 8, false, 10);
		catalog.addCatalogItem("Eggs", 6.50, true, 5);
		
	}
}
