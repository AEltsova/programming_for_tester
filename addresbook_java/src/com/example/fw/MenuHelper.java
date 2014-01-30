package com.example.fw;

import org.netbeans.jemmy.operators.JMenuBarOperator;

public class MenuHelper extends HelperBasic{


	public MenuHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void pushFolder(){
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|New Folder...");
	}

	public void removeFolder() {
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|Delete");
		
	}
}
