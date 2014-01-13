package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ModifyContactTest extends BasicClass{

	@Test
	public void modificationContact(){
		controlManager.checkNavigationHelper().openSourseForTest();
		//save list
	    List<InitContactParameter> oldList= controlManager.checkContactHelper().getContactList();
		
		//do something
	    int y = 0;
		controlManager.checkContactHelper().selectContactOnNumber(y);
		InitContactParameter cont = new InitContactParameter( );
		Random rand = new Random();
		cont.fname ="First name"+ rand.nextInt(365);
		cont.lname = "Last name" + rand.nextInt(365);
		cont.address = "some street";
		cont.home =  "h" +rand.nextInt(1000);
		cont.mobile = "m"+rand.nextInt(1000);
		cont.work = "602896502";
		cont.email2 = "some2@address.com";
		cont.year = "19"+rand.nextInt(100);
		cont.add2 = "d"+rand.nextInt(1000);
	    controlManager.checkContactHelper().createAndInit(cont);
	    controlManager.checkContactHelper().submitModify();
	    controlManager.checkNavigationHelper().comingHome();
	    //save new list
	    List<InitContactParameter> newList= controlManager.checkContactHelper().getContactList();
	    
	    //check
	    oldList.remove(y);
	    oldList.add(cont);
	    Collections.sort(oldList);
	  assertEquals(newList, oldList);
		}
}
