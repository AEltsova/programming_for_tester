package com.aeltsova.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BasicClass{

	@Test
	public void createContact(){
	Contact contact = new Contact().setFirstName("Test").setLastName("TestLastName");
	controlManager.getContHelp().createContact(contact);
	Contact saved = controlManager.getContHelp().getFirstCont();
	Assert.assertEquals(contact, saved);
		}
}
