package com.example.tests;

import org.testng.annotations.Test;

public class CreateGroupTest2 extends BasicClass {
@Test
  public void testNonEmpty() throws Exception {
    openSourseForTest();
    createNewGroup();
    InitGroupParameter x = new InitGroupParameter( );
    x.nameGroup = "name 1";
    x.head= "emty head 1";
    x.foot= "big foot 1";
	initGroup(x);
    submitSomething();
    comingHome();
  }
}