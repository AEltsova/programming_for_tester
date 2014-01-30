package com.example.fw;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;


public class ApplicationManager {
	
	
	public FolderHelper folderHelper;
	private JFrameOperator mainWindow;
	private MenuHelper menuHelper; 
	
	public ApplicationManager () {	
   }
	
	public FolderHelper getFolderHelp(){
		if (folderHelper == null){ folderHelper = new FolderHelper(this);}
        return folderHelper;  	
	}	
	
	public MenuHelper getMenuHelp(){
		if (menuHelper == null){ menuHelper = new MenuHelper(this);}
        return menuHelper;  	
	}	
	
	public void stop() {	
		getApplication().requestClose();
}
	
	public JFrameOperator getApplication() {
		if (mainWindow == null){
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();
				mainWindow = new JFrameOperator("jAddressBook");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				return mainWindow;
		}
}