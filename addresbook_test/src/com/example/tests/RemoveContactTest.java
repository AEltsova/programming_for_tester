package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class RemoveContactTest extends BasicClass {

	@Test
	public void removeContact(){
		controlManager.checkNavigationHelper().openSourseForTest();
		//save list
		SortedListOf<InitContactParameter> oldList= controlManager.checkContactHelper().getContactList();
		
		//do something
	    int y = 0;
	    controlManager.checkContactHelper().deleteContact(y);
	
	    //save new list
	    SortedListOf<InitContactParameter> newList= controlManager.checkContactHelper().getContactList();
	    
	    //check
	    oldList.remove(y);
	    assertEquals(newList.size(), oldList.size());
	   	}
}