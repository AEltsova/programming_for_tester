package com.aeltsova.tests;

public class Contact implements Comparable<Contact> {

	public String firstName;
	public String lastName;
	
	public Contact setFirstName(String name) {
		if (name == null){firstName = "";}
		else {firstName = name;}
		return this;
	}
	
	public Contact setLastName(String name) {
		if (name == null){lastName = "";}
		else {lastName = name;}
		return this;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Contact [" + firstName + ", " + lastName
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Contact other) {
		 if (this.firstName == null)
		     this.firstName = "";
		   if (other.firstName == null)
		      other.firstName = "";
				return 	this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());	}
	
	}
	
	

