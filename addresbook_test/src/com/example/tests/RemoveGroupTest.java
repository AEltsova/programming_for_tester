package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class RemoveGroupTest extends BasicClass {
	
	@Test
	public void removeGroup(){
	    controlManager.checkNavigationHelper().openSourseForTest();
	    controlManager.checkNavigationHelper().goToGroup();
		  
	    //save old list
	    List<InitGroupParameter> oldList= controlManager.checkGroupHelper().getGroupList();
	    
	    // do something
	    int y = 0;
	    controlManager.checkGroupHelper().deleteGroup(y);
	    controlManager.checkNavigationHelper().goToGroup();
	    
	    //look what happened
	    List<InitGroupParameter> newList= controlManager.checkGroupHelper().getGroupList();
	    
	    //check 
	    oldList.remove(y);
	    Collections.sort(oldList);
	  assertEquals(newList.size(), oldList.size());
	    }
}