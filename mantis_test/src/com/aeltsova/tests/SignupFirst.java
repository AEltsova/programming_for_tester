package com.aeltsova.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import com.aeltsova.fw.User;

public class SignupFirst extends BasicClass{
	
	public User user = new User().setLogin("Tester").setEmail("test@localhost").setPassword("12345");
	
	@BeforeClass
	public void createMailUser(){
		if (!controlManager.getJHelper().doesUserExist(user.login)){
		controlManager.getJHelper().createUser(user.login, user.password);
	}}
	
	@AfterClass
	public void deleteMailUser(){
		if (controlManager.getJHelper().doesUserExist(user.login)){
		controlManager.getJHelper().deleteUser(user.login);}
	}
	
	@Test
	public void signUpTest() throws InterruptedException{
		
		controlManager.getAccHelper().signup(user);
		controlManager.getAccHelper().login(user);
		assertThat(controlManager.getAccHelper().isLogged(),equalTo(user.login));
	}
	
   // @Test
    public void existingUserShouldNotSignup() {
            try {
            	controlManager.getAccHelper().signup(user);
            } catch (Exception e) { 
                    assertThat(e.getMessage(), containsString("That username is already being used")); 
                    return; 
            }
            Assert.fail("Exception expected");
    }


}
