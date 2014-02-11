package com.example.fw;

import com.example.tests.InitGroupParameter;
import com.example.utils.SortedListOf;

public class ApplicationModel {

	private SortedListOf<InitGroupParameter> groups;
	
	public SortedListOf<InitGroupParameter> getGroup(){
		return groups;
	}

	public void setGroups(SortedListOf<InitGroupParameter> groups) {
		this.groups = groups;
	}

	public ApplicationModel addGroup(InitGroupParameter x) {
		groups.add(x);
		return this;
		
	}

	public ApplicationModel removeGroup(int y) {
		groups.remove(y);
		return this;
	}
	
	
}
