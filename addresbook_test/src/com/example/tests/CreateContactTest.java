package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactFromFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CreateContactTest extends BasicClass{

	
	@DataProvider
	public Iterator<Object[]> loadContactFromCsv() throws IOException {
		return convertContListForProvider(loadContactFromFile(new File("contactList.txt"))).iterator();
		}
	
@Test  (dataProvider = "loadContactFromCsv")
  public void testContact(InitContactParameter z) throws Exception {
	//save list
	SortedListOf<InitContactParameter> oldList= controlManager.checkContactHelper().getContactList();
	
	//do something
	controlManager.checkContactHelper().createContactCombo(z);

    //save new list
    SortedListOf<InitContactParameter> newList= controlManager.checkContactHelper().getContactList();
    
    //check
    assertThat(newList, equalTo(oldList.withAdded(z))); 
  }
}

