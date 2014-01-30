package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestFolder extends BasicClass {

	@Test
	public void createFolderTest(){
	    String folder="newFolder";
		SortedListOf<String> oldList = controlManager.getFolderHelp().getFolder();
		controlManager.getFolderHelp().createFolder(folder);
		SortedListOf<String> newList = controlManager.getFolderHelp().getFolder();		
	    assertThat(newList,equalTo(oldList.withAdded(folder)));
	}
	
	@Test
	public void createTwoFolderTest(){
	    String folder="newFolder1";
	    String folder2="newFolder2";
		SortedListOf<String> oldList = controlManager.getFolderHelp().getFolder();
		assertThat(controlManager.getFolderHelp().createFolder(folder), is(nullValue()));
		assertThat(controlManager.getFolderHelp().createFolder(folder2), is(nullValue()));
		SortedListOf<String> newList = controlManager.getFolderHelp().getFolder();		
	    assertThat(newList,equalTo(oldList.withAdded(folder,folder2)));
	}
	
	@Test
	public void createTwinsFolderTest(){
	    String folder="newTwinsFolder";
	    String folder2="newTwinsFolder";
		SortedListOf<String> oldList = controlManager.getFolderHelp().getFolder();
		assertThat(controlManager.getFolderHelp().createFolder(folder), is(nullValue()));
		assertThat(controlManager.getFolderHelp().createFolder(folder2), containsString("Duplicated folder"));
		SortedListOf<String> newList = controlManager.getFolderHelp().getFolder();		
	    assertThat(newList,equalTo(oldList.withAdded(folder)));
	}
}
