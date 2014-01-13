package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ModifyGroupTest extends BasicClass {
	
	@Test
	public void modificationGroup(){
	    controlManager.checkNavigationHelper().openSourseForTest();
	    controlManager.checkNavigationHelper().goToGroup();
	  
	    //save old list
	    List<InitGroupParameter> oldList= controlManager.checkGroupHelper().getGroupList();
	    
	    // do something
	    int y = 0;
	    controlManager.checkGroupHelper().modifyGroup(y);	
	    InitGroupParameter group = new InitGroupParameter( );
	    group.nameGroup = "name new data";
	    controlManager.checkGroupHelper().initGroup(group);
	    controlManager.checkGroupHelper().submitModifyGroup();
	    controlManager.checkNavigationHelper().goToGroup();
	    
	    //look what happened
	    List<InitGroupParameter> newList= controlManager.checkGroupHelper().getGroupList();
	    
	    //check 
	    oldList.remove(y);
	    oldList.add(group);
	    Collections.sort(oldList);
	  assertEquals(newList.size(), oldList.size());
	    }

}