package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CheckPhones extends BasicClass{
	
	@Test
	public void checkPhones (){
		SortedListOf<InitContactParameter> mainList= controlManager.checkContactHelper().mainTable();
		controlManager.checkContactHelper().printPhones();
		SortedListOf<InitContactParameter> printList= controlManager.checkContactHelper().printPhoneTable();
		  assertEquals(mainList.size(), printList.size());
		  assertEquals(mainList, printList);
		
	}

}
