package com.example.tests;

import java.io.*;
import java.util.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.createRandomGroups;
import static com.example.tests.ContactDataGenerator.createRandomContact;;

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
	
	protected boolean mustHave(){
		check++;
		if (check> mustHaveCheck){
			check = 0;
			return true;
		} else {return false;}
		
	}

	@AfterTest
	public void tearDown() throws Exception {
		controlManager.stop();
	  }
	
	@DataProvider
	public Iterator<Object[]> randInitGroup() {
		return convertListForProvider(createRandomGroups(3)).iterator();
	}
	
	protected List<Object[]> convertListForProvider(List<InitGroupParameter> something) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (InitGroupParameter smthng : something) {
			list.add(new Object[]{smthng});
		}
		return list;
	}
	protected List<Object[]> convertContListForProvider(List<InitContactParameter> something) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (InitContactParameter smthng : something) {
			list.add(new Object[]{smthng});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randInitContact() {
		return convertContListForProvider(createRandomContact(5)).iterator();
		}

	public static String GenerateString() {
		Random rand = new Random();
		String str = new String();
		switch (rand.nextInt(4)) { 
		case 0: str = ""; break;
		case 1: for (int i = 0; i<3; i++) {
			int c = rand.nextInt(10);
			str += c;}
       	case 2: int z = rand.nextInt(20);
			       for (int i = 0; i<z; i++) 
			       {
				   int c = 'a' + rand.nextInt(26);
				   str += (char)c;
				   } str+= " ";
		case 3: int x = rand.nextInt(20);
	            	for (int i = 0; i<x; i++) 
	            	{
			        int c = 'A' + rand.nextInt(26);
			        str += (char)c;
			        } 
     	           	break;}
		return str;
	            	}

	public static String GenerateNumber(int q) {
		Random rand = new Random();
		String strn = new String();
		switch (rand.nextInt(3)){ 
		case 0:  strn = ""; 	break;
		case 1: for (int i = 0; i<q; i++) {
			int c = rand.nextInt(10);
			strn += c;} 	break;
		case 2: String num = new String();
		for (int i = 0; i<3; i++){num +=rand.nextInt(10);}
			strn ="+7 ("+ num +") ";
			for (int i = 0; i<5; i++){num +=rand.nextInt(10);}
			strn += num; 	break;
			}
			return strn;
	}

}