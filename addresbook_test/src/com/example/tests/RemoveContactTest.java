package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class RemoveContactTest extends BasicClass {

	@Test
	public void removeContact(){
		controlManager.checkNavigationHelper().openSourseForTest();
		//save list
	    List<InitContactParameter> oldList= controlManager.checkContactHelper().getContactList();
		
		//do something
	    int y = 0;
	    controlManager.checkContactHelper().deleteContact(y);
	    controlManager.checkNavigationHelper().comingHome();
	    //save new list
	    List<InitContactParameter> newList= controlManager.checkContactHelper().getContactList();
	    
	    //check
	    oldList.remove(y);
	    Collections.sort(oldList);
	  assertEquals(newList.size(), oldList.size());
	   	}
}