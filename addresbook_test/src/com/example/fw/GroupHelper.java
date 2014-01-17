package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.InitGroupParameter;
import com.example.utils.*;

public class GroupHelper extends BasicHelper {
	
	public GroupHelper(ApplicationManager linkToAM) {
		super(linkToAM);
	}

	protected SortedListOf<InitGroupParameter> cachedGroups;
	
	public SortedListOf<InitGroupParameter> getGroupList() {
		if (cachedGroups == null) { makeCachedGroup();}
		return cachedGroups;
	}
	
	private void makeCachedGroup(){
		cachedGroups = new SortedListOf<InitGroupParameter>();
		linkToAM.checkNavigationHelper().goToGroup();
		List<WebElement> cheks =driver.findElements(By.name("selected[]"));
		for (WebElement newChek : cheks) {
			InitGroupParameter group = new InitGroupParameter();
			String title = newChek.getAttribute("title");
			group.withName(title.substring("Select (".length(), title.length() - ")".length()));
			cachedGroups.add(group);
		}
	}
	
	public GroupHelper createGroup (InitGroupParameter x){
		createNewGroup();
		initGroup(x);
		linkToAM.checkNavigationHelper().submit();
		makeCachedGroup();
		return this;
	}

	public InitGroupParameter modifyGroupCombo(int y){
		modifyGroup(y);	
	    InitGroupParameter group = new InitGroupParameter( ).withName("name new data");
	    initGroup(group);
	    submitModifyGroup();
		makeCachedGroup();
		return group;
	}
	
	public GroupHelper deleteGroup(int x) {
		selectGroupOnNumber(x);
		removeGroup();
		makeCachedGroup();
		return this;
	}

	public void removeGroup() {
		pushTheButton(By.name("delete"));
		cachedGroups = null;
	}
	
	public GroupHelper initGroup(InitGroupParameter myBook) {
		pointInData(By.name("group_name"), myBook.getNameGroup());
		pointInData(By.name("group_header"), myBook.getHead());
		pointInData(By.name("group_footer"), myBook.getFoot());
		return this;
	}

	public GroupHelper createNewGroup() {
		pushTheButton(By.name("new"));
		return this;
	}

	public GroupHelper selectGroupOnNumber(int x) {
		pushTheButton(By.xpath("//input[@name = 'selected[]']["+(x+1)+"]"));
		return this;
	}
	
	public GroupHelper modifyGroup(int i) {
		selectGroupOnNumber(i);
		pushTheButton(By.name("edit"));	
		return this;
	}
	
	public GroupHelper submitModifyGroup() {
		pushTheButton(By.name("update"));	
		cachedGroups = null;
		return this;
	}
}
