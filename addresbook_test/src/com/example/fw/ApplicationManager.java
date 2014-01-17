package com.example.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	
	public ContactHelper contactF1;
	public GroupHelper groupF1;
	public NavigationHelper navigationF1;
	public  WebDriver driver;
	public  String baseUrl;
	
	public ApplicationManager () {	
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
		driver.get(baseUrl + "/addressbookv4.1.4/");
   }
	
	public NavigationHelper checkNavigationHelper () {
		if (navigationF1 == null) {
		            navigationF1 = new NavigationHelper(this);
		} 
		return navigationF1;
	}

	public GroupHelper checkGroupHelper () {
		if (groupF1 == null) {
			groupF1 = new GroupHelper(this);
		}
		return groupF1;
	}
	
	public ContactHelper checkContactHelper(){
	if (contactF1 == null){
			contactF1 = new ContactHelper(this);
	}
	return contactF1;
	}

	public void stop() {
	    driver.quit();
}
}