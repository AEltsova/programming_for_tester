package com.example.tests;

import org.testng.annotations.Test;


public class CreateContactTest extends BasicClass{



@Test
  public void testContact() throws Exception {
	openSourseForTest();
    InitContactParameter z = new InitContactParameter( );
	z.fname ="First name";
	z.lname = "Last name";
	z.address = "some street";
	z.home = "789456123";
	z.mobile = "45632110";
	z.email = "some@address.com";
	z.work = "602896502";
	z.email2 = "some2@address.com";
	z.day = "1";
	z.mounth = "January";
	z.year = "1990";
	z.add2 = "dcvsvsvv";
	z.ph2 = "sdvsdvsv";
    createAndInit(z);
    submitSomething();
    comingHome();
  }
  
  }
