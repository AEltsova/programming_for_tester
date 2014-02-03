package com.aeltsova.fw;

import java.io.IOException;


public class ProcessHelper extends HelperBasic {

	private Process  exeRun;
	
	public ProcessHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}
	
	void startApplication() throws IOException {
 		String path = "F:/AddressBookWin/AddressBook.exe";
 		exeRun = Runtime.getRuntime().exec(path);
	}
	
	void stopApplication() throws IOException {
		exeRun.destroy();
	}
	}
