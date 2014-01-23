package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	
	public ContactHelper contactF1;
	public GroupHelper groupF1;
	public NavigationHelper navigationF1;
	public  WebDriver driver;
	public  String baseUrl;
	private Properties properties;
	
	public ApplicationManager (Properties properties) {	
	    this.properties = properties;
	    String browser = properties.getProperty("browser");
	    if ("firefox".equals(browser)){ driver = new FirefoxDriver();}
	    else if("ie".equals(browser)){ driver = new InternetExplorerDriver();}
	    else {throw new Error ("Never heard about this browser");}
	    baseUrl = properties.getProperty("baseUrl");
		driver.get(baseUrl);
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