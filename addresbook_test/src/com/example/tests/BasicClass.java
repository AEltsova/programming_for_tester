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
		for (int i =0; i<2; i++){
			InitGroupParameter groupR = new InitGroupParameter()	
			.withName(GenerateString())
			.withHead(GenerateString())
			.withFooter(GenerateString());
			list.add(new Object[]{groupR});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randInitContact() {
		Random rnd = new Random();
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i =0; i<4; i++){
			Integer day = rnd.nextInt(30)+1;
			Integer mon = rnd.nextInt(11);
			Integer year = rnd.nextInt(110)+1904;
			InitContactParameter cont = new InitContactParameter()	
			.withFname(GenerateString())
			.withLname (GenerateString())
			.withAddress (GenerateString())
			.withHome (GenerateString())
			.withMobile(GenerateNumber(8))
			.withEmail (GenerateString())
			.withWork(GenerateNumber(7))
			.withEmail2(GenerateString())
			.withDay(day.toString())
			.withMounth(Month(mon))
			.withYear(year.toString())
			.withAdd2 (GenerateString())
			.withPh2 (GenerateNumber(7));
			list.add(new Object[]{cont});
		}
		return list.iterator();
	}

	public String GenerateString() {
		Random rand = new Random();
		String str = new String();
		switch (rand.nextInt(4)) { 
		case 0: str = ""; break;
		case 1: str+= GenerateNumber(3);  
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

	public String GenerateNumber(int q) {
		Random rand = new Random();
		if (rand.nextInt(3)== 0) 
			return "";
		else { 
			String str = new String();
			for (int i = 0; i<q; i++) {
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