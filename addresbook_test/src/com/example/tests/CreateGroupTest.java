package com.example.tests;

import org.testng.annotations.Test;

public class CreateGroupTest extends BasicClass {
  
@Test 
  public void testEmpty() throws Exception {
    controlManager.checkNavigationHelper().openSourseForTest();
    controlManager.checkNavigationHelper().goToGroup();
    controlManager.checkGroupHelpr().createNewGroup();
    controlManager.checkGroupHelpr().initGroup(new InitGroupParameter("", "", ""));
    controlManager.checkNavigationHelper().submit();
    controlManager.checkNavigationHelper().comingHome();
  }
  }

  
