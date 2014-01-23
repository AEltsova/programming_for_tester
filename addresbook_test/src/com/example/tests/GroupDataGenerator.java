package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.tests.BasicClass.GenerateString;

public class GroupDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3){
		System.out.println("Please chaeck parameters: 'amount' 'file_name' 'format'");
		return;
		}
	
   	int amount = Integer.parseInt(args[0]);
   	File file = new File(args[1]);
   	String format = new String(args[2]);
   	
   	if (file.exists()){
   		System.out.println("Stop this madness, and remove existing file");
		return;
   	}
   	
   	List<InitGroupParameter> group = createRandomGroups(amount);
   	if ("csv".equals(format)){
   		saveGroupAsCsv(group, file);
   	} else if  ("xml".equals(format)){
   		saveGroupAsXml(group, file);}
   	else {
   		System.out.println("! Wrong format !");
   	return;
   	}
	}

	private static void saveGroupAsXml(List<InitGroupParameter> groups, File file) throws IOException {
			FileWriter writer = new FileWriter(file);
			for (InitGroupParameter group : groups) {
				writer.write(group.getNameGroup()+", "+ group.getHead()+", "+group.getFoot()+ "\n");
			}
			writer.close();
			
		}

	private static void saveGroupAsCsv(List<InitGroupParameter> groups, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (InitGroupParameter group : groups) {
			writer.write(group.getNameGroup()+","+ group.getHead()+","+group.getFoot()+ ",!" +"\n");
		}
		writer.close();
		
	}

	public static List<InitGroupParameter> createRandomGroups(int amount) {
		List<InitGroupParameter> list = new ArrayList<InitGroupParameter>();
		for (int i =0; i<amount; i++){
			InitGroupParameter groupR = new InitGroupParameter()	
			.withName(GenerateString())
			.withHead(GenerateString())
			.withFooter(GenerateString());
			list.add(groupR);
		}
		return list;
	}
	
	public static List<InitGroupParameter> loadGroupFromCsv(File file) throws IOException{
		List<InitGroupParameter> list = new ArrayList<InitGroupParameter>();
		FileReader read = new FileReader(file);
		BufferedReader buff = new BufferedReader(read);
		String line =buff.readLine();
		while( line!= null){
			String[] part = line.split(",");
			InitGroupParameter group = new InitGroupParameter().withName(part[0]).withHead(part[1]).withFooter(part[2]);
			list.add(group);
			line = buff.readLine();
		};
		buff.close();
		return list;
	} 

}
