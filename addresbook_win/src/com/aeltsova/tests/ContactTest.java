package com.aeltsova.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aeltsova.utils.SortedListOf;

public class ContactTest extends BasicClass{

	@Test
	public void createContact() throws IOException, InterruptedException{
	Contact contact = new Contact().setFirstName("Test").setLastName("TestLastName");
	SortedListOf<Contact> old =controlManager.getContHelp().getALLCont();
	controlManager.getContHelp().createContact(contact);
	SortedListOf<Contact> saved = controlManager.getContHelp().getALLCont();
	Assert.assertEquals(saved, old.withAdded(contact));
		}
}
