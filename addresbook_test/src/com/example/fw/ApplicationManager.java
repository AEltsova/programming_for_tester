package com.example.fw;

import java.util.concurrent.TimeUnit;

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
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }
	
	public NavigationHelper checkNavigationHelper () {
		if (navigationF1 == null) {
		            navigationF1 = new NavigationHelper(this);
		} 
		return navigationF1;
	}

	public GroupHelper checkGroupHelpr () {
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