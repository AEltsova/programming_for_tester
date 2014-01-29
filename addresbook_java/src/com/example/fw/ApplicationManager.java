package com.example.fw;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;


public class ApplicationManager {
	
	
	public  String baseUrl;
	public FolderHelper folderHelper;
	private JFrameOperator mainFrame;
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
		if (mainFrame == null){
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();
				mainFrame = new JFrameOperator("jAddressBook");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				return mainFrame;
		}
}