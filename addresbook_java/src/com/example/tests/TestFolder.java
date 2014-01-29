package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestFolder extends BasicClass {

	@Test
	public void createFolderTest(){
	    String folder="newFolder7";
		SortedListOf<String> oldList = controlManager.getFolderHelp().getFolder();
		controlManager.getFolderHelp().createFolder(folder);
		SortedListOf<String> newList = controlManager.getFolderHelp().getFolder();		
	    assertThat(newList,equalTo(oldList.withAdded(folder)));
	}
}
