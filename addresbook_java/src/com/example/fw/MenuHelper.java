package com.example.fw;

import org.netbeans.jemmy.operators.JMenuBarOperator;

public class MenuHelper {

	private final ApplicationManager someControl;

	public MenuHelper(ApplicationManager applicationManager) {
		this.someControl = applicationManager;
	}

	public void pushFolder(){
		JMenuBarOperator menu = new JMenuBarOperator(someControl.getApplication());
		menu.pushMenuNoBlock("File|New Folder...");
	}

}
