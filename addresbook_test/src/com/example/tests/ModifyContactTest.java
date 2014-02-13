package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ModifyContactTest extends BasicClass{

	@Test
	public void modificationContact(){
		//save list
		SortedListOf<InitContactParameter> oldList= controlManager.getModel2().getContacts();
		
		//do something
	    int y = 0;
		InitContactParameter cont = controlManager.checkContactHelper().modifyContactCombo(y, oldList.get(y+1));

	    //save new list
		SortedListOf<InitContactParameter> newList= controlManager.getModel2().getContacts();
	    
	    //check
	    assertThat(newList, equalTo(oldList.without(y).withAdded(cont))); 	  
	    
	    if (controlManager.getProperty("checing").equals("yes")){
	        assertThat(controlManager.getModel2().getContacts(), equalTo(controlManager.checkContactHelper().getContactList())); 
	        assertThat(controlManager.getModel2().getContacts(), equalTo(controlManager.checHkibernateHelper().listContacts()));
		}
}}
