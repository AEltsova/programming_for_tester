package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class CreateContactTest extends BasicClass{

@Test
  public void testContact() throws Exception {
	controlManager.checkNavigationHelper().openSourseForTest();
	//save list
    List<InitContactParameter> oldList= controlManager.checkContactHelper().getContactList();
	
	//do something
	controlManager.checkContactHelper().createContact();
    InitContactParameter z = new InitContactParameter( );
    Random rand = new Random();
    String str = new String();
    for (int i = 0; i<7; i++) {
		int c = 'a' + rand.nextInt(26);
		str += (char)c;}
	z.fname = str;
	z.lname = "Last name";
	z.address = "some street";
	z.home = "789456123";
	z.mobile = "45632110";
	z.email = "some@address.com";
	z.work = "602896502";
	z.email2 = "some2@address.com";
	z.day = "1";
	z.mounth = "January";
	z.year = "1990";
	z.add2 = "dcvsvsvv";
	z.ph2 = "sdvsdvsv";
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

