package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class CreateGroupTest extends BasicClass {
  
@Test 
  public void testEmpty() throws Exception {
    controlManager.checkNavigationHelper().openSourseForTest();
    controlManager.checkNavigationHelper().goToGroup();
    
    //save old list
    List<InitGroupParameter> oldList= controlManager.checkGroupHelper().getGroupList();
    
    // do something
    controlManager.checkGroupHelper().createNewGroup();
    InitGroupParameter newGroup = new InitGroupParameter("", "", "");
	controlManager.checkGroupHelper().initGroup(newGroup);
    controlManager.checkNavigationHelper().submit();
    controlManager.checkNavigationHelper().goToGroup();
    
    //look what happened
    List<InitGroupParameter> newList= controlManager.checkGroupHelper().getGroupList();
    
    //check 
    oldList.add(newGroup);
    Collections.sort(oldList);
  assertEquals(newList, oldList);
  }
  }

  
