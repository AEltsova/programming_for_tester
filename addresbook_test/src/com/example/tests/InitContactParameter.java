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
	//	final int prime = 31;
		int result = 1;
	//	result = prime * result + ((add2 == null) ? 0 : add2.hashCode());
	//result = prime * result + ((address == null) ? 0 : address.hashCode());
	//result = prime * result + ((day == null) ? 0 : day.hashCode());
	//result = prime * result + ((email == null) ? 0 : email.hashCode());
	//result = prime * result + ((email2 == null) ? 0 : email2.hashCode());
	//result = prime * result + ((fname == null) ? 0 : fname.hashCode());
	//result = prime * result + ((home == null) ? 0 : home.hashCode());
	//result = prime * result + ((lname == null) ? 0 : lname.hashCode());
	//result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
	//result = prime * result + ((mounth == null) ? 0 : mounth.hashCode());
	//result = prime * result + ((ph2 == null) ? 0 : ph2.hashCode());
	//result = prime * result + ((work == null) ? 0 : work.hashCode());
	//result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		/*if (add2 == null) {
			if (other.add2 != null)
				return false;
		} else if (!add2.equals(other.add2))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (email2 == null) {
			if (other.email2 != null)
				return false;
		} else if (!email2.equals(other.email2))
			return false;*/
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
	/*	if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;*/
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		/*if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (mounth == null) {
			if (other.mounth != null)
				return false;
		} else if (!mounth.equals(other.mounth))
			return false;
		if (ph2 == null) {
			if (other.ph2 != null)
				return false;
		} else if (!ph2.equals(other.ph2))
			return false;
		if (work == null) {
			if (other.work != null)
				return false;
		} else if (!work.equals(other.work))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;*/
		return true;
	}
	
	@Override
	public int compareTo(InitContactParameter other) {
		return 	this.lname.toLowerCase().compareTo(other.lname.toLowerCase());	}
	
	
}