package com.aeltsova.fw;

import java.io.IOException;

public class ApplicationManager {
	
	private ProcessHelper processH;
	private AutoItHelper autoHelp;
	private ContactHelper contactH; 
	
	public ApplicationManager () {
   }
	
	public ContactHelper getContHelp(){
		if (contactH == null){ contactH = new ContactHelper(this);}
        return contactH;  	
	}		
	
	public ProcessHelper getProcHelp(){
		if (processH == null){ processH = new ProcessHelper(this);}
        return processH;  	
	}	
	
	public AutoItHelper getAutoHelp(){
		if (autoHelp == null){ autoHelp = new AutoItHelper(this);}
        return autoHelp;  	
	}	
	
	public void start() throws IOException {	
		getProcHelp().startApplication();
	}
	
	public void stop() throws IOException {	
		getProcHelp().stopApplication();
}

}