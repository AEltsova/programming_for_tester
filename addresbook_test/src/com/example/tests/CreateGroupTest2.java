package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CreateGroupTest2 extends BasicClass {
	
@Test  (dataProvider = "randInitGroup")
  public void testNonEmpty( InitGroupParameter x) throws Exception {
    //save old list
	SortedListOf<InitGroupParameter> oldList= controlManager.checkGroupHelper().getGroupList();
    
    // do something
    controlManager.checkGroupHelper().createGroup(x);

    //look what happened
    SortedListOf<InitGroupParameter> newList= controlManager.checkGroupHelper().getGroupList();
    
    //check 
    assertThat(newList, equalTo(oldList.withAdded(x))); 
  }
}