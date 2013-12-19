package com.example.tests;

import org.testng.annotations.Test;


public class CreateContactTestEmpty extends BasicClass{



@Test
  public void testContact() throws Exception {
	openSourseForTest();
    createAndInit(new InitContactParameter("", "", "", "", "", "", "", "", "-", "-", "", "", ""));
    submitSomething();
    comingHome();
  }
  
  }
