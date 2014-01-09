package com.example.tests;

import org.testng.annotations.Test;

public class RemoveContactTest extends BasicClass {

	@Test
	public void removeContact(){
		controlManager.checkNavigationHelper().openSourseForTest();
	    controlManager.checkContactHelper().deleteContact(1);
	    controlManager.checkNavigationHelper().comingHome();
	   	}
}