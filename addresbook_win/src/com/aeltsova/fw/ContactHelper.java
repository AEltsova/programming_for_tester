package com.aeltsova.fw;

import com.aeltsova.tests.Contact;

public class ContactHelper extends HelperBasic {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		waitMainWindow();
		addAndWait();
		sendBoringText(contact);
		saveSomething();
		waitMainWindow();
		
	}

	public void saveSomething() {
		onControl.getAutoHelp().click("Save");
	}

	public void sendBoringText(Contact contact) {
		onControl.getAutoHelp().send("TDBEdit12", contact.firstName).send("TDBEdit11", contact.lastName);
	}

	public void addAndWait() {
		onControl.getAutoHelp().click("Add")
		.winWaitAndActivate("Add Contact", "", 3000);
	}

	public void waitMainWindow() {
		onControl.getAutoHelp().winWaitAndActivate("AddressBook Portable", "", 3000);
	}

	public Contact getFirstCont() {
		onControl.getAutoHelp().winWaitAndActivate("AddressBook Portable", "", 3000)
				.click("TListView1").send("{DOWN}{SPACE}").click("Edit").winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact().setFirstName(onControl.getAutoHelp().getText("TDBEdit12"))
		                        	   .setLastName(onControl.getAutoHelp().getText("TDBEdit11"));
		onControl.getAutoHelp().click("Cancel");
		return contact;
	}
	
}
