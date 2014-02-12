package com.example.fw;

import com.example.tests.InitContactParameter;
import com.example.tests.InitGroupParameter;
import com.example.utils.SortedListOf;

public class ApplicationModel {

	private SortedListOf<InitGroupParameter> groups;
	private SortedListOf<InitContactParameter> contacts;
	
	
	public void setContacts(SortedListOf<InitContactParameter> contacts) {
		this.contacts = contacts;
	}

	public SortedListOf<InitContactParameter> getContacts() {
		return contacts;
	}

	public SortedListOf<InitGroupParameter> getGroup(){
		return groups;
	}

	public void setGroups(SortedListOf<InitGroupParameter> groups) {
		this.groups = groups;
	}

	public ApplicationModel addGroup(InitGroupParameter x) {
		groups.add(x);
		return this;
		
	}

	public ApplicationModel removeGroup(int y) {
		groups.remove(y);
		return this;
	}
	
	public ApplicationModel addContact(InitContactParameter x) {
		contacts.add(x);
		return this;
		
	}

	public ApplicationModel removeContact(int y) {
		contacts.remove(y);
		return this;
	}
	
	
}
