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
	List<Contact> old = controlManager.getContHelp().getALLCont("fileold.csv");
	controlManager.getContHelp().createContact(contact);
	List<Contact> saved = controlManager.getContHelp().getALLCont("filenew.csv");
	old.add(contact);
    Collections.sort(old);
	Assert.assertEquals(saved, old);
		}
}
