package com.example.tests;

public class InitContactParameter implements Comparable <InitContactParameter>{
	private String fname;
	private String lname;
	private String address;
	private String home;
	private String email;
	private String mobile;
	private String work;
	private String email2;
	private String day;
	private String mounth;
	private String year;
	private String add2;
	private String ph2;
	private String id;

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
		
	
	public String getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getAddress() {
		return address;
	}
	public String getHome() {
		return home;
	}
	public String getEmail() {
		return email;
	}
	public String getMobile() {
		return mobile;
	}
	public String getWork() {
		return work;
	}
	public String getEmail2() {
		return email2;
	}
	public String getDay() {
		return day;
	}
	public String getMounth() {
		return mounth;
	}
	public String getYear() {
		return year;
	}
	public String getAdd2() {
		return add2;
	}
	public String getPh2() {
		return ph2;
	}
	
	public InitContactParameter withLname(String name){
		this.lname = name;
		return this;
	}
	
	public InitContactParameter withFname(String name){
		this.fname = name;
		return this;
	}
	public InitContactParameter withAddress(String name){
		this.address = name;
		return this;
	}
	public InitContactParameter withAdd2(String name){
		this.add2 = name;
		return this;
	}
	
	public InitContactParameter withHome(String name){
		this.home = name;
		return this;
	}
	public InitContactParameter withMobile(String name){
		this.mobile = name;
		return this;
	} 
	
	public InitContactParameter withWork(String name){
		this.work = name;
		return this;
	}
	
	public InitContactParameter withEmail(String name) {
		if (name.contains("@mail")){this.email = name;}
		else if (name != null &&  !name.isEmpty()){this.email = name +"@mail.com";}
        this.email = name;
		return this;
	} 
	
	public InitContactParameter withEmail2 (String name) {
		if (name.contains("@mail")){this.email2 = name;}
		else if ( name != null &&  !name.isEmpty()){this.email2 = name +"@mail.com";}
		else this.email2 = name;
		return this;
	}
	public InitContactParameter withDay (String name) {
		this.day = name;
		return this;
	}
	public InitContactParameter withYear (String name) {
		this.year = name;
		return this;
	}
	
	public InitContactParameter withMounth (String name) {
		this.mounth = name;
		return this;
	}
	
	public InitContactParameter withPh2 (String name) {
		this.ph2 = name;
		return this;
	}
	
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public void setMounth(String mounth) {
		this.mounth = mounth;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public void setPh2(String ph2) {
		this.ph2 = ph2;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "InitContactParameter [fname=" + fname + ", lname=" + lname
				+ "home=" + home + "]";
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