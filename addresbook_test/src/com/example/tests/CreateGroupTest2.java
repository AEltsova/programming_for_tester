package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class CreateGroupTest2 extends BasicClass {
	
@Test
  public void testNonEmpty() throws Exception {
    controlManager.checkNavigationHelper().openSourseForTest();
    controlManager.checkNavigationHelper().goToGroup();

    //save old list
    List<InitGroupParameter> oldList= controlManager.checkGroupHelper().getGroupList();
    
    // do something
    controlManager.checkGroupHelper().createNewGroup();
    InitGroupParameter x = new InitGroupParameter( );
    Random rand = new Random(47);
    x.nameGroup = "name "+ rand.nextInt(47);
    x.head= "empty head "+ rand.nextInt(47);
    x.foot= "big foot "+ rand.nextInt(47);
	controlManager.checkGroupHelper().initGroup(x);
    controlManager.checkNavigationHelper().submit();
    controlManager.checkNavigationHelper().goToGroup();

    //look what happened
    List<InitGroupParameter> newList= controlManager.checkGroupHelper().getGroupList();
    
    //check 
    oldList.add(x);
    Collections.sort(oldList);
  assertEquals(newList.size(), oldList.size());
    
  }
}