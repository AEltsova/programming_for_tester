package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class RemoveFolder extends BasicClass {
	
	@Test
	public void removeFolderTest(){
		SortedListOf<String> oldList = controlManager.getFolderHelp().getFolder();
		String fold = new String();
		fold = oldList.get(1);
		controlManager.getFolderHelp().removeFolderCombo(fold);
		SortedListOf<String> newList = controlManager.getFolderHelp().getFolder();		
	    assertThat(newList,equalTo(oldList.without(fold)));
	} 

}
