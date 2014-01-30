package com.example.fw;

import javax.swing.JDialog;

import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;

public class HelperBasic {
	
	protected final ApplicationManager someControl;
	protected final JFrameOperator mainFrame;

	public HelperBasic(ApplicationManager applicationManager) {
		this.someControl = applicationManager;
		this.mainFrame = someControl.getApplication();
	
	}

	protected String waitForError(String title, int time) {
		long start = System.currentTimeMillis();
		long nowTime = start;
		while (nowTime<start+time){
	    JDialog dialog= JDialogOperator.findJDialog(mainFrame.getOwner(), title, false,false );  
	    if (dialog != null){
	    	JDialogOperator dialOP = new JDialogOperator(dialog);
	    	String message = new JLabelOperator(dialOP).getText();
	    	dialOP.requestClose();
			return message;
	    }
	    try{Thread.sleep(500);}
	    catch(InterruptedException e){e.printStackTrace();}
	    nowTime = System.currentTimeMillis();
		}
		return null;
	}

}
