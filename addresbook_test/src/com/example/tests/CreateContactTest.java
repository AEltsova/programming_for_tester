package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactFromCsv;
import static com.example.tests.ContactDataGenerator.loadContactFromXml;
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
	public Iterator<Object[]> loadContactFromFile() throws IOException {
		return convertContListForProvider(loadContactFromXml(new File("contactList.xml"))).iterator();
		}
	
@Test  (dataProvider = "loadContactFromFile")
  public void testContact(InitContactParameter z) throws Exception {
	//save list
	SortedListOf<InitContactParameter> oldList= controlManager.getModel2().getContacts();
	
	//do something
	controlManager.checkContactHelper().createContactCombo(z);

    //save new list
    SortedListOf<InitContactParameter> newList= controlManager.getModel2().getContacts();
    
    //check
    assertThat(newList, equalTo(oldList.withAdded(z))); 
    
    if (mustHave()){
    if (controlManager.getProperty("checing").equals("yes")){
        assertThat(controlManager.getModel2().getContacts(), equalTo(controlManager.checkContactHelper().getContactList())); 
        assertThat(controlManager.getModel2().getContacts(), equalTo(controlManager.checHkibernateHelper().listContacts()));
	}
}}}

