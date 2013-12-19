package com.example.tests;

import org.testng.annotations.Test;



public class CreateGroupTest extends BasicClass {
  
@Test 
  public void testEmpty() throws Exception {
    openSourseForTest();
    createNewGroup();
    initGroup(new InitGroupParameter("", "", ""));
    submitSomething();
    comingHome();
  }
  }

  
