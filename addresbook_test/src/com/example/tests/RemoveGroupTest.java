package com.example.tests;

import org.testng.annotations.Test;

public class RemoveGroupTest extends BasicClass {
	
	@Test
	public void removeGroup(){
	    controlManager.checkNavigationHelper().openSourseForTest();
	    controlManager.checkNavigationHelper().goToGroup();
	    controlManager.checkGroupHelper().deleteGroup(1);
	    controlManager.checkNavigationHelper().comingHome();
	    }
}