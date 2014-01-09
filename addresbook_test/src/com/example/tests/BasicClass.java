package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;



public class BasicClass extends Object{
	
	static protected ApplicationManager controlManager;

	@BeforeTest
	public void setUp() throws Exception {
		controlManager = new ApplicationManager();
	    }

	@AfterTest
	public void tearDown() throws Exception {
		controlManager.stop();
	  }

}
