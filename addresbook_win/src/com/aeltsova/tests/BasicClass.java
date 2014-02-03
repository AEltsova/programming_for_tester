package com.aeltsova.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aeltsova.fw.ApplicationManager;


public class BasicClass {

	static protected ApplicationManager controlManager;
		 
	@BeforeTest
	public void setUp() throws Exception {
		controlManager = new ApplicationManager();
		controlManager.start();
	    }

	@AfterTest
	public void tearDown() throws Exception {
		controlManager.stop();
	  }
	}