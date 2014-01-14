package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class CreateContactTest extends BasicClass{

@Test  (dataProvider = "randInitContact")
  public void testContact(InitContactParameter z) throws Exception {
	controlManager.checkNavigationHelper().openSourseForTest();
	//save list
    List<InitContactParameter> oldList= controlManager.checkContactHelper().getContactList();
	
	//do something
	controlManager.checkContactHelper().createContact();
     controlManager.checkContactHelper().createAndInit(z);
    controlManager.checkNavigationHelper().submit();
    controlManager.checkNavigationHelper().comingHome();
    //save new list
    List<InitContactParameter> newList= controlManager.checkContactHelper().getContactList();
    
    //check
    oldList.add(z);
    Collections.sort(oldList);
  assertEquals(newList, oldList);
  }
}

