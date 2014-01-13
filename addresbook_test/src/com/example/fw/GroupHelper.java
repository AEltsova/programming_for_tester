package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.InitGroupParameter;

public class GroupHelper extends BasicHelper {
	
	public GroupHelper(ApplicationManager linkToAM) {
		super(linkToAM);
	}

	public void initGroup(InitGroupParameter myBook) {
		pointInData(By.name("group_name"), myBook.nameGroup);
		pointInData(By.name("group_header"), myBook.head);
		pointInData(By.name("group_footer"), myBook.foot);
	}

	public void createNewGroup() {
		pushTheButton(By.name("new"));
	}
	
	public void deleteGroup(int x) {
		selectGroupOnNumber(x);
		pushTheButton(By.name("delete"));	
	}
	
	public void selectGroupOnNumber(int x) {
		pushTheButton(By.xpath("//input[@name = 'selected[]']["+(x+1)+"]"));
	}
	
	public void modifyGroup(int i) {
		selectGroupOnNumber(i);
		pushTheButton(By.name("edit"));	
	}
	
	public void submitModifyGroup() {
		pushTheButton(By.name("update"));		
	}
	
	public List<InitGroupParameter> getGroupList() {
		List<InitGroupParameter> arrayList = new ArrayList<InitGroupParameter>();
		List<WebElement> cheks =driver.findElements(By.name("selected[]"));
		for (WebElement newChek : cheks) {
			InitGroupParameter group = new InitGroupParameter();
			String title = newChek.getAttribute("title");
			group.nameGroup = title.substring("Select (".length(), title.length() - ")".length());
			arrayList.add(group);
		}
		return arrayList;
	}
}
