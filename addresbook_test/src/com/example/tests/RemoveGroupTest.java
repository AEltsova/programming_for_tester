package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class RemoveGroupTest extends BasicClass {
	
	@Test
	public void removeGroup(){
	    //save old list
	    SortedListOf<InitGroupParameter> oldList= controlManager.checkGroupHelper().getGroupList();
	    
	    // do something
	    int y = 0;
	    controlManager.checkGroupHelper().deleteGroup(y);
	    
	    //look what happened
	    SortedListOf<InitGroupParameter> newList= controlManager.checkGroupHelper().getGroupList();
	    
	    //check 
	    assertThat(newList, equalTo(oldList.without(y))); 
	    }
}