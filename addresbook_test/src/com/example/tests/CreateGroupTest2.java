package com.example.tests;

import java.util.*;

import org.testng.annotations.Test;

public class CreateGroupTest2 extends BasicClass {
	
@Test
  public void testNonEmpty() throws Exception {
    controlManager.checkNavigationHelper().openSourseForTest();
    controlManager.checkNavigationHelper().goToGroup();
    controlManager.checkGroupHelper().createNewGroup();
    InitGroupParameter x = new InitGroupParameter( );
    Random rand = new Random(47);
    x.nameGroup = "name "+ rand.nextInt(47);
    x.head= "emty head "+ rand.nextInt(47);
    x.foot= "big foot "+ rand.nextInt(47);
	controlManager.checkGroupHelper().initGroup(x);
    controlManager.checkNavigationHelper().submit();
    controlManager.checkNavigationHelper().comingHome();
  }
}