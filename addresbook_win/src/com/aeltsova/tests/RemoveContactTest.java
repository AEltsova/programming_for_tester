package com.aeltsova.tests;

import org.testng.annotations.Test;

public class RemoveContactTest extends BasicClass{
	@Test
	public void createContact(){
	controlManager.getContHelp().removeFirstContact();
	controlManager.getContHelp().getEmptyCont();
	System.out.println("Good done!");	

		}

}
