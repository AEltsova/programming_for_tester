package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelper{
	
	public NavigationHelper(ApplicationManager linkToAM) {
		super(linkToAM);
	}

	public void comingHome() {
		if (! checkOnMain()){
		pushTheButton(By.linkText("home"));
	}}

	public void submit() {
		pushTheButton(By.name("submit"));

	}

	public void openSourseForTest() {
		if (! checkOnMain()){
        comingHome();
	}}

	private boolean checkOnMain() {
		if (driver.findElements(By.id("maintable")).size() > 0){return true;}
		else {return false;}
	}

	public void goToGroup (){
		if (! chekOnGroup()){
		pushTheButton(By.linkText("groups"));}
	}

	private boolean chekOnGroup() {
		if (driver.getCurrentUrl().contains("/group.php") 
				&& driver.findElements(By.name("New group")).size() > 0){return true;}
		else {return false;}
	}
}
