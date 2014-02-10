package com.aeltsova.fw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void getEmptyCont() {
		waitMainWindow();
		onControl.getAutoHelp().click("TListView1").send("{DOWN}{SPACE}").click("Edit")
		.winWaitAndActivate("Information", "", 5000).click("TButton1");
		waitMainWindow();
	}

	public void removeFirstContact() {
		waitMainWindow();
		onControl.getAutoHelp().click("TListView1").send("{DOWN}{SPACE}").click("Delete")
		.winWaitAndActivate("Confirm", "", 3000).click("TButton2");
		waitMainWindow();
	}
	
	public List<Contact> getALLCont() throws IOException, InterruptedException {

		onControl.getAutoHelp().winWaitAndActivate("AddressBook Portable", "", 3000)
				.click("Select All").click("Export")
			.send("Edit1","listOfGroup.csv").send("{ENTER}").winWaitAndActivate("Information", "", 5000).click("TButton1");
        File file = new File("listOfGroup.csv");
        FileReader read = new FileReader(file);
		BufferedReader buff = new BufferedReader(read);
		String line0 =buff.readLine();
		String line =buff.readLine();
		List <Contact> contacts = new ArrayList<Contact>();
		while( line!= null){
			String[] part = line.split(",");
		Contact cont = new Contact().setFirstName(part[0]).setLastName(part[1]);
		contacts.add(cont);
		line =buff.readLine();
		}
		buff.close();
		onControl.getAutoHelp().winWaitAndActivate("AddressBook Portable", "", 3000)
		.click("Deselect All");
		file.delete();
		return contacts;
	}
}
