package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ModifyGroupTest extends BasicClass {
	
	@Test
	public void modificationGroup(){
	    //save old list
		SortedListOf<InitGroupParameter> oldList= controlManager.getModel().getGroup();
	    
	    // do something
	    int y = 0;
	    InitGroupParameter group =  controlManager.checkGroupHelper().modifyGroupCombo(y);
	    
	    //look what happened
	    SortedListOf<InitGroupParameter> newList= controlManager.getModel().getGroup();
	    
	    //check 
	    assertThat(newList, equalTo(oldList.without(y).withAdded(group))); 
	    
	    if (controlManager.getProperty("checing").equals("yes")){
	        assertThat(controlManager.getModel().getGroup(), equalTo(controlManager.checkGroupHelper().getGroupList())); 
	        assertThat(controlManager.getModel().getGroup(), equalTo(controlManager.checHkibernateHelper().listGroups()));
	      }
	    
	    }

}