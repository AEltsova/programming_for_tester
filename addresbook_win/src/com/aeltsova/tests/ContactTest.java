package com.aeltsova.tests;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BasicClass{

	@Test
	public void createContact() throws IOException, InterruptedException{
	Contact contact = new Contact().setFirstName("Test").setLastName("TestLastName");
	String filename = "fileold.csv";
	List<Contact> old = controlManager.getContHelp().getALLCont(filename);
	controlManager.getContHelp().createContact(contact);
	String filename2 = "filenew.csv";
	List<Contact> saved = controlManager.getContHelp().getALLCont(filename2);
	old.add(contact);
    Collections.sort(saved);
    Collections.sort(old);
	Assert.assertEquals(saved, old);
		}
}
