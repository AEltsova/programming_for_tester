package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
    assertThat(newList, equalTo(oldList.withAdded(z))); 
  }
}

