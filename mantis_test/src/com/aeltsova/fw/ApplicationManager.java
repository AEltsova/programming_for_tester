package com.aeltsova.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	

	private  WebDriver driver;

	public  String baseUrl;
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private AccHelper accHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;
	
	public ApplicationManager (Properties properties) {	
	    this.properties = properties;
	   }
	
	public WebDriver getDriver() {
	    String browser = properties.getProperty("browser");
		if (driver == null) {
		    if ("firefox".equals(browser)){ driver = new FirefoxDriver();}
		    else if("ie".equals(browser)){ driver = new InternetExplorerDriver();}
		    else {throw new Error ("Never heard about this browser");}
		    baseUrl = properties.getProperty("baseUrl");
			driver.get(baseUrl);
					}
		return driver;
	}
	
	public JamesHelper getJHelper() {
		if (jamesHelper == null) {
			jamesHelper = new JamesHelper(this);
		}
		return jamesHelper;
	}
	
	public MailHelper getMailHelper() {
		if (mailHelper == null) {
			mailHelper = new MailHelper(this);
		}
		return mailHelper;
	}

	public AccHelper getAccHelper() {
		if (accHelper == null) {
			accHelper = new AccHelper(this);
		}
		return accHelper;
	}
	
	public HibernateHelper checHkibernateHelper () {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
		}
		return hibernateHelper;
	}

	public void stop() {
	    driver.quit();
}
	
	public String getProperty(String key) {
		return properties.getProperty(key);		
	}

}