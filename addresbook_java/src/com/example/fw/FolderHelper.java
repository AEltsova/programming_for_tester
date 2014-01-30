package com.example.fw;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import com.example.utils.SortedListOf;

public class FolderHelper extends HelperBasic{

	
	public FolderHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	
	}

	public SortedListOf<String> getFolder() {
		SortedListOf<String> list = new SortedListOf<String>();
		JFrameOperator mainFR= mainFrame;
        JTreeOperator tree = new JTreeOperator(mainFR);
        Object[] children = tree.getChildren(tree.getRoot());
        for (Object child : children){
        	list.add(""+child);
        }
		return new SortedListOf<String>(list);
	}

	public String createFolder(String folder) {
		someControl.getMenuHelp().pushFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JTextFieldOperator(dialog).setText(folder);
		new JButtonOperator(dialog, "OK").push();
		return waitForError("Warning", 3000);
		}

	public void removeFolderCombo(String folder) {
		JFrameOperator mainFR= mainFrame;
        JTreeOperator tree = new JTreeOperator(mainFR);
         tree.selectRow(tree.findRow(folder));
		someControl.getMenuHelp().removeFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JButtonOperator(dialog, "Yes").push();
	}
	
}
