package com.aeltsova.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
	
	public ApplicationManager linkToAM;
	public WebDriver driver;
	public boolean acceptNextAlert = true;
	
	protected HelperBase(ApplicationManager linkToAM){
		this.linkToAM = linkToAM;
		this.driver = linkToAM.getDriver();
	}
	

	public boolean isElementPresent(By by) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	    try {
	    	return driver.findElements(by).size()>0;
	    } finally {
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	     driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	public void pointInData(By point, String data) {
		if (data != null){
		driver.findElement(point).clear();
		driver.findElement(point).sendKeys(data);
		}
	}

	public void pushTheButton(By linkText) {
		driver.findElement(linkText).click();
	}
	
	public void openUrl(String name){
		driver.get(linkToAM.getProperty("baseUrl")+ name);
	}
	
	public void openUrlAll(String name){
		driver.get(name);
	}

}
