package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class CreateContactTestEmpty extends BasicClass{

@Test
  public void testContact() throws Exception {
	controlManager.checkNavigationHelper().openSourseForTest();
	//save list
    List<InitContactParameter> oldList= controlManager.checkContactHelper().getContactList();
	
	//do something
	controlManager.checkContactHelper().createContact();
    InitContactParameter contact = new InitContactParameter("", "", "", "", "", "", "", "", "-", "-", "", "", "");
	controlManager.checkContactHelper().createAndInit(contact);
    controlManager.checkNavigationHelper().submit();
    controlManager.checkNavigationHelper().comingHome();
    //save new list
    List<InitContactParameter> newList= controlManager.checkContactHelper().getContactList();
    
    //check
    oldList.add(contact);
    Collections.sort(oldList);
  assertEquals(newList, oldList);
  }
  }
