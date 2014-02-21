package com.aeltsova.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccHelper extends HelperBase {
	
	public AccHelper(ApplicationManager linkToAM) {
		  super(linkToAM);
		}

	public void signup(User user) throws InterruptedException {
		openUrl("/");
		pushTheButton(By.linkText("Signup for a new account"));
		pointInData(By.name("username"), user.login);
		pointInData(By.name("email"), user.email);
		pushTheButton(By.cssSelector("input.button"));
		
        WebElement errorMessage = driver.findElement(By.cssSelector("table.width50 tbody tr td p"));
        if (errorMessage != null) {
                throw new RuntimeException(errorMessage.getText());
        }

		
		Thread.sleep(60000);
		
		Msg msg = linkToAM.getMailHelper().getNewMail(user.login, user.password);
		String somelink = msg.getConfirmationLink(); 
		openUrlAll(somelink);
		
		pointInData(By.name("password"), user.password);
		pointInData(By.name("password_confirm"), user.password);
		pushTheButton(By.cssSelector("input.button"));
		
	}

	public String isLogged() {
		 WebElement element = driver.findElement(By.cssSelector("td.login-info-left span"));
         return element.getText();

	}

	public void login(User user) {
		openUrl("/");
		pointInData(By.name("username"), user.login);
		pointInData(By.name("password"), user.password);
		pushTheButton(By.cssSelector("input.button"));
		
	}

}
