package com.aeltsova.tests;

import java.io.*;
import java.util.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aeltsova.fw.ApplicationManager;

public class BasicClass extends Object{

	static protected ApplicationManager controlManager;
	protected int check;
	protected int mustHaveCheck;
		 
	@BeforeTest
	public void setUp() throws Exception {
		String confFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(confFile)));
		controlManager = new ApplicationManager(properties);
		check = 0;
		mustHaveCheck = Integer.parseInt(properties.getProperty("mustHaveCheck", "0"));
	    }
	
	
	@AfterTest
	public void tearDown() throws Exception {
		controlManager.stop();
	  }
	

}