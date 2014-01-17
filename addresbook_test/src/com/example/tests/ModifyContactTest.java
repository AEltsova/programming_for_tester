package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ModifyContactTest extends BasicClass{

	@Test
	public void modificationContact(){
		//save list
		SortedListOf<InitContactParameter> oldList= controlManager.checkContactHelper().getContactList();
		
		//do something
	    int y = 0;
		InitContactParameter cont = controlManager.checkContactHelper().modifyContactCombo (y);

	    //save new list
		SortedListOf<InitContactParameter> newList= controlManager.checkContactHelper().getContactList();
	    
	    //check
	    oldList.remove(y);
	    oldList.add(cont);
	  assertEquals(newList, oldList);
		}
}
