package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
	    assertThat(newList, equalTo(oldList.without(y).withAdded(cont))); 	    
		}
}
