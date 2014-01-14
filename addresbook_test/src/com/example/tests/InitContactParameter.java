package com.example.tests;

public class InitContactParameter implements Comparable <InitContactParameter>{
	public String fname;
	public String lname;
	public String address;
	public String home;
	public String email;
	public String mobile;
	public String work;
	public String email2;
	public String day;
	public String mounth;
	public String year;
	public String add2;
	public String ph2;

	public InitContactParameter(String fname, String lname, String address,
			String home, String email, String mobile, String work,
			String email2, String day, String mounth, String year, String add2,
			String ph2) {
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.home = home;
		this.email = email;
		this.mobile = mobile;
		this.work = work;
		this.email2 = email2;
		this.day = day;
		this.mounth = mounth;
		this.year = year;
		this.add2 = add2;
		this.ph2 = ph2;
	}
	public InitContactParameter() {
	}
		
	@Override
	public String toString() {
		return "InitContactParameter [fname=" + fname + ", lname=" + lname
				+ "]";
	}
	@Override
	public int hashCode() {
		int result = 1;
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
		InitContactParameter other = (InitContactParameter) obj;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;

		return true;
	}
	
	@Override
	public int compareTo(InitContactParameter other) {

  if (this.lname == null)
     this.lname = "";
   if (other.lname == null)
      other.lname = "";
		return 	this.lname.toLowerCase().compareTo(other.lname.toLowerCase());	}
	
	
}