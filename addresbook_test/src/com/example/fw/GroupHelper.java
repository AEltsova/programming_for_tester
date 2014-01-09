package com.example.fw;

import org.openqa.selenium.By;

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
		pushTheButton(By.xpath("//input[@name = 'selected[]']["+x+"]"));
	}
	
	public void modifyGroup(int i) {
		selectGroupOnNumber(i);
		pushTheButton(By.name("edit"));	
	}
	
	public void submitModifyGroup() {
		pushTheButton(By.name("update"));		
	}
}
