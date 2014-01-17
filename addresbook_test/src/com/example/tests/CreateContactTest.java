package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CreateContactTest extends BasicClass{

@Test  (dataProvider = "randInitContact")
  public void testContact(InitContactParameter z) throws Exception {
	//save list
	SortedListOf<InitContactParameter> oldList= controlManager.checkContactHelper().getContactList();
	
	//do something
	controlManager.checkContactHelper().createContactCombo(z);

    //save new list
    SortedListOf<InitContactParameter> newList= controlManager.checkContactHelper().getContactList();
    
    //check
    oldList.add(z);
  assertEquals(newList, oldList);
  }
}

