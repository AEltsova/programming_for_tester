package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupFromCsv;
import static com.example.tests.GroupDataGenerator.loadGroupFromXml;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CreateGroupTest2 extends BasicClass {
	
	@DataProvider
	public Iterator<Object[]> loadGroupFromFile() throws IOException {
		return convertListForProvider(loadGroupFromXml(new File("groupList.xml"))).iterator();
	}
	
@Test  (dataProvider = "loadGroupFromFile")
  public void testNonEmpty( InitGroupParameter x) throws Exception {
    //save old list
	SortedListOf<InitGroupParameter> oldList= controlManager.getModel().getGroup();
    
    // do something
    controlManager.checkGroupHelper().createGroup(x);

    //look what happened
    SortedListOf<InitGroupParameter> newList= controlManager.getModel().getGroup();
    
    //check 
    assertThat(newList, equalTo(oldList.withAdded(x))); 
    
    if (mustHave()){
    if (controlManager.getProperty("checing").equals("yes")){
    assertThat(controlManager.getModel().getGroup(), equalTo(controlManager.checkGroupHelper().getGroupList())); 
    assertThat(controlManager.getModel().getGroup(), equalTo(controlManager.checHkibernateHelper().listGroups()));
  }}
}}