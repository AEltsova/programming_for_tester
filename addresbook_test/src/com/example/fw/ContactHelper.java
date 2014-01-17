package com.example.fw;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.InitContactParameter;
import com.example.utils.SortedListOf;

public class ContactHelper extends BasicHelper {
	
	protected ContactHelper(ApplicationManager linkToAM) {
		super(linkToAM);
	}
	
	protected SortedListOf<InitContactParameter> cachedContacts;
	
	public SortedListOf<InitContactParameter> getContactList() {
		if (cachedContacts == null) { makeCachedContacts();}
		return cachedContacts;
	}

	private void makeCachedContacts(){
	linkToAM.checkNavigationHelper().comingHome();
	cachedContacts = new SortedListOf<InitContactParameter>();
	int i = 2;
	List<WebElement> cheks = driver.findElements(By.name("selected[]"));;
	for (;i<= (cheks.size()+1);) {
		WebElement cellName = driver.findElement(By.xpath("//tr["+i+"]/td[2]"));
		WebElement cellLastName = driver.findElement(By.xpath("//tr["+i+"]/td[3]"));
		InitContactParameter contact = new InitContactParameter();
		contact.withLname(cellName.getText());
		contact.withFname(cellLastName.getText());
		cachedContacts.add(contact);
		i++;
	}
}	
	public InitContactParameter modifyContactCombo (int y){
		selectContactOnNumber(y);
		Random rand = new Random();
		InitContactParameter cont = new InitContactParameter( )
		.withFname("First name"+ rand.nextInt(365))
		.withLname("Last name" + rand.nextInt(365))
		.withAddress("some street")
		.withHome("h" +rand.nextInt(1000))
		.withMobile("m"+rand.nextInt(1000))
		.withWork("602896502")
		.withAdd2("d"+rand.nextInt(1000));
		createAndInit(cont);
		submitModify();
		makeCachedContacts();
		return cont;
	}
	
	public void createContactCombo (InitContactParameter z){
		createContact();
	    createAndInit(z);
	    linkToAM.checkNavigationHelper().submit();	
		makeCachedContacts();
	}
	
	public ContactHelper deleteContact(int index) {
		selectContactOnNumber(index);
		removeContact();
		makeCachedContacts();
		   return this;
}
	
	public ContactHelper createAndInit(InitContactParameter justWord) {
	   pointInData(By.name("firstname"), justWord.getFname());
	   pointInData(By.name("lastname"), justWord.getLname());
	   pointInData(By.name("address"), justWord.getAddress());
	   pointInData(By.name("home"), justWord.getHome());
	   pointInData(By.name("email"), justWord.getEmail());
	   pointInData(By.name("mobile"), justWord.getMobile());
	   pointInData(By.name("work"), justWord.getWork());
	   pointInData(By.name("email2"), justWord.getEmail2());
	   pointInData(By.name("byear"), justWord.getYear());
	   pointInData(By.name("address2"), justWord.getAdd2());
	   pointInData(By.name("phone2"), justWord.getPh2());
	   initBirthDay(By.name("bday"), justWord.getDay());
	   initBirthDay(By.name("bmonth"),justWord.getMounth());
	   return this;
	}

	public ContactHelper createContact() {
		pushTheButton(By.linkText("add new"));
		   return this;
	}

	public void removeContact() {
		pushTheButton(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
	}

	public ContactHelper selectContactOnNumber(int index) {
		pushTheButton(By.xpath("(//img[@alt='Edit'])["+(index+1)+"]"));
		   return this;
	}

	public ContactHelper submitModify() {
		pushTheButton(By.xpath("(//input[@name='update'])[1]"));
		cachedContacts = null;
		   return this;
	}

}
