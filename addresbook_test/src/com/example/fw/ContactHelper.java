package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.InitContactParameter;

public class ContactHelper extends BasicHelper {
	
	protected ContactHelper(ApplicationManager linkToAM) {
		super(linkToAM);
	}

	public void createAndInit(InitContactParameter justWord) {
	   pointInData(By.name("firstname"), justWord.fname);
	   pointInData(By.name("lastname"), justWord.lname);
	   pointInData(By.name("address"), justWord.address);
	   pointInData(By.name("home"), justWord.home);
	   pointInData(By.name("email"), justWord.email);
	   pointInData(By.name("mobile"), justWord.mobile);
	   pointInData(By.name("work"), justWord.work);
	   pointInData(By.name("email2"), justWord.email2);
	   pointInData(By.name("byear"), justWord.year);
	   pointInData(By.name("address2"), justWord.add2);
	   pointInData(By.name("phone2"), justWord.ph2);
	   initBirthDay(By.name("bday"), justWord.day);
	   initBirthDay(By.name("bmonth"),justWord.mounth);
	}

	public void createContact() {
		pushTheButton(By.linkText("add new"));
	}
	
	public void deleteContact(int index) {
		selectContactOnNumber(index);
		pushTheButton(By.xpath("(//input[@name='update'])[2]"));	
}

	public void selectContactOnNumber(int index) {
		pushTheButton(By.xpath("(//img[@alt='Edit'])["+(index+1)+"]"));
	}

	public void submitModify() {
		pushTheButton(By.xpath("(//input[@name='update'])[1]"));
	}

	public List<InitContactParameter> getContactList() {
		List<InitContactParameter> arrayOfContact = new ArrayList<InitContactParameter>();
		int i = 2;
		List<WebElement> cheks = driver.findElements(By.name("selected[]"));;
		for (;i<= (cheks.size()+1);) {
			WebElement cellName = driver.findElement(By.xpath("//tr["+i+"]/td[2]"));
			WebElement cellLastName = driver.findElement(By.xpath("//tr["+i+"]/td[3]"));
			InitContactParameter contact = new InitContactParameter();

			contact.lname = cellName.getText();
			contact.fname = cellLastName.getText();
			arrayOfContact.add(contact);
			i++;
		}
		return arrayOfContact;
	}
	
}
