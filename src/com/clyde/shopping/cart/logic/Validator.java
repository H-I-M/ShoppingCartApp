package com.clyde.shopping.cart.logic;

import java.util.Set;
import java.util.regex.Pattern;

//This class will validate users input
public class Validator
{
	Pattern pat;
	public Validator()
	{
		
	}
	
	public boolean isValidInput(int value)
	{
		if(value < 0 || value > 9)  //at this point we will facilitate for up 9 items
			return false;
		else
			return true;
	}
	
	public boolean isSelectionValid(int select, Set set)
	{
		if(set.isEmpty())
			return false;
		
		if(select > set.size())
			return false;
		
		return true;
	}

}
