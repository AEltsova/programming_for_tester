package com.example.tests;

import org.testng.annotations.Test;

public class ModifyGroupTest extends BasicClass {
	
	@Test
	public void modificationGroup(){
	    controlManager.checkNavigationHelper().openSourseForTest();
	    controlManager.checkNavigationHelper().goToGroup();
	    controlManager.checkGroupHelper().modifyGroup(1);	
	    InitGroupParameter group = new InitGroupParameter( );
	    group.nameGroup = "name new data";
	    controlManager.checkGroupHelper().initGroup(group);
	    controlManager.checkGroupHelper().submitModifyGroup();
	    controlManager.checkNavigationHelper().comingHome();
	    }

}