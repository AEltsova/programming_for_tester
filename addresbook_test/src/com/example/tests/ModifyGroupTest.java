package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ModifyGroupTest extends BasicClass {
	
	@Test
	public void modificationGroup(){
	    //save old list
		SortedListOf<InitGroupParameter> oldList= controlManager.checkGroupHelper().getGroupList();
	    
	    // do something
	    int y = 0;
	    InitGroupParameter group =  controlManager.checkGroupHelper().modifyGroupCombo(y);
	    
	    //look what happened
	    SortedListOf<InitGroupParameter> newList= controlManager.checkGroupHelper().getGroupList();
	    
	    //check 
	    oldList.remove(y);
	    oldList.add(group);
	    assertEquals(newList, oldList);
	    }

}