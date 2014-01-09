package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends BasicHelper{
	
	public NavigationHelper(ApplicationManager linkToAM) {
		super(linkToAM);
	}

	public void comingHome() {
		pushTheButton(By.linkText("home"));
	}

	public void submit() {
		pushTheButton(By.name("submit"));
	}

	public void openSourseForTest() {
		driver.get(linkToAM.baseUrl + "/addressbookv4.1.4/");
	}

	public void goToGroup (){
		pushTheButton(By.linkText("groups"));
	}
}
