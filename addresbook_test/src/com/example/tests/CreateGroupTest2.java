package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class CreateGroupTest2 extends BasicClass {
	
@Test  (dataProvider = "randInitGroup")
  public void testNonEmpty( InitGroupParameter x) throws Exception {
    controlManager.checkNavigationHelper().openSourseForTest();
    controlManager.checkNavigationHelper().goToGroup();

    //save old list
    List<InitGroupParameter> oldList= controlManager.checkGroupHelper().getGroupList();
    
    // do something
    controlManager.checkGroupHelper().createNewGroup();
 	controlManager.checkGroupHelper().initGroup(x);
    controlManager.checkNavigationHelper().submit();
    controlManager.checkNavigationHelper().goToGroup();

    //look what happened
    List<InitGroupParameter> newList= controlManager.checkGroupHelper().getGroupList();
    
    //check 
    oldList.add(x);
    Collections.sort(oldList);
  assertEquals(newList, oldList);
    
  }
}