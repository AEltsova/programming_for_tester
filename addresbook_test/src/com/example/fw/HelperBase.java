package com.example.fw;

import org.openqa.selenium.WebDriver;

public class HelperBase {
	
	public ApplicationManager linkToAM;
	public WebDriver driver;
	
	protected HelperBase(ApplicationManager linkToAM){
		this.linkToAM = linkToAM;
		this.driver = linkToAM.getDriver();
	}

}
