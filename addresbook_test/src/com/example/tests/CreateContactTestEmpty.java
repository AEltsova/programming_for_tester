package com.example.tests;

import org.testng.annotations.Test;

public class CreateContactTestEmpty extends BasicClass{

@Test
  public void testContact() throws Exception {
	controlManager.checkNavigationHelper().openSourseForTest();
	controlManager.checkContactHelper().createContact();
    controlManager.checkContactHelper().createAndInit(new InitContactParameter("", "", "", "", "", "", "", "", "-", "-", "", "", ""));
    controlManager.checkNavigationHelper().submit();
    controlManager.checkNavigationHelper().comingHome();
  }
  }
