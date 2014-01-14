package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

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
	
	@DataProvider
	public Iterator<Object[]> randInitGroup() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i =0; i<3; i++){
			InitGroupParameter groupR = new InitGroupParameter();	
			groupR.nameGroup = GenerateString();
			groupR.head = GenerateString();
			groupR.foot = GenerateString();
			list.add(new Object[]{groupR});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randInitContact() {
		Random rnd = new Random();
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i =0; i<5; i++){
			Integer day = rnd.nextInt(30);
			Integer mon = rnd.nextInt(11);
			Integer year = rnd.nextInt(110)+1904;
			InitContactParameter cont = new InitContactParameter();	
			cont.fname =  GenerateString();
			cont.lname =  GenerateString();
			cont.address= GenerateString();
			cont.home =   GenerateString();
			cont.mobile=  GenerateNumber();
			cont.email =  GenerateString();
			cont.work =   GenerateNumber();
			cont.email2 = GenerateString();
			cont.day =  day.toString();
			cont.mounth = Month(mon);
			cont.year =   year.toString();
			cont.add2 =   GenerateString();
			cont.ph2 =    GenerateNumber();
			list.add(new Object[]{cont});
		}
		return list.iterator();
	}

	public String GenerateString() {
		Random rand = new Random();
		if (rand.nextInt(3)== 0) 
			return "";
		else { 
			String str = new String();
			int z = rand.nextInt(30);
			for (int i = 0; i<z; i++) {
				int c = 'a' + rand.nextInt(26);
				str += (char)c;
			}
			
			return str;
			}
	}
	

	public String GenerateNumber() {
		Random rand = new Random();
		if (rand.nextInt(3)== 0) 
			return "";
		else { 
			String str = new String();
			for (int i = 0; i<8; i++) {
				int c = rand.nextInt(10);
				str += c;
			}
			
			return str;
			}
	}

public static String  Month( int i){
 	String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
return month[i];
}}