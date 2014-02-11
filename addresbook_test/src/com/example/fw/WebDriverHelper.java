package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebDriverHelper extends HelperBase {
	

	public WebDriver driver;
	public boolean acceptNextAlert = true;
	private WebDriverWait wait;

	protected WebDriverHelper(ApplicationManager linkToAM){
		super(linkToAM);
		this.driver = linkToAM.getDriver();
		wait = new WebDriverWait(driver, 10);
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

	public void initBirthDay(By locator, String text) {
		if (text != null){
		new Select(driver.findElement(locator)).selectByVisibleText(text);
	    }
	}

	public void pushTheButton(By linkText) {
		driver.findElement(linkText).click();
	}
}
