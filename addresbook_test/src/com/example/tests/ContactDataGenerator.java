package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.tests.BasicClass.GenerateString;
import static com.example.tests.BasicClass.GenerateNumber;;

public class ContactDataGenerator {

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
	   	
	   	List<InitContactParameter> contact = createRandomContact(amount);
	   	if ("csv".equals(format)){
	   		saveContactAsCsv(contact, file);
	   	} else if  ("xml".equals(format)){
	   		saveContactAsXml(contact, file);}
	   	else {
	   		System.out.println("! Wrong format !");
	   	return;
	   	}
		}

	public static List<InitContactParameter> createRandomContact(int amount) {
			Random rnd = new Random();
			List<InitContactParameter> list = new ArrayList<InitContactParameter>();
			for (int i =0; i<amount; i++){
				Integer day = rnd.nextInt(30)+1;
				Integer mon = rnd.nextInt(11);
				Integer year = rnd.nextInt(110)+1904;
				InitContactParameter cont = new InitContactParameter()	
				.withFname(GenerateString())
				.withLname (GenerateString())
				.withAddress (GenerateString())
				.withHome (GenerateNumber(6))
				.withMobile(GenerateNumber(8))
				.withEmail (GenerateString())
				.withWork(GenerateNumber(7))
				.withEmail2(GenerateString())
				.withDay(day.toString())
				.withMounth(Month(mon))
				.withYear(year.toString())
				.withAdd2 (GenerateString())
				.withPh2 (GenerateNumber(7));
				list.add(cont);
			}
			return list;
	}
		public static String  Month( int i){
		 	String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		return month[i];
		}

		private static void saveContactAsXml(List<InitContactParameter> cont, File file) throws IOException {
				FileWriter writer = new FileWriter(file);
				for (InitContactParameter contact : cont) {
					writer.write(contact.getFname()+", "+ contact.getLname()+", "+contact.getAddress()+", "
				+ contact.getHome()+", "+contact.getMobile()+", "+ contact.getWork()+", "+contact.getEmail()
				+", "+ contact.getEmail2()+", "+contact.getDay()+", "+ contact.getMounth()+", "+contact.getYear()
				+", "+ contact.getAdd2()+", "+contact.getPh2()+ "\n");
				}
				writer.close();	
			}

		private static  void saveContactAsCsv(List<InitContactParameter> cont, File file) throws IOException {
			FileWriter writer = new FileWriter(file);
			for (InitContactParameter contact : cont) {
				writer.write(contact.getFname()+","+ contact.getLname()+","+contact.getAddress()+","
			+ contact.getHome()+","+contact.getMobile()+","+ contact.getWork()+","+contact.getEmail()
			+","+ contact.getEmail2()+","+contact.getDay()+","+ contact.getMounth()+","+contact.getYear()
			+","+ contact.getAdd2()+","+contact.getPh2()+ ",!"+"\n");
			}
			writer.close();
		}
		
		public static List<InitContactParameter> loadContactFromFile(File file) throws IOException {
			List<InitContactParameter>  list = new ArrayList<InitContactParameter>();
			FileReader read = new FileReader(file);
			BufferedReader buff = new BufferedReader(read);
			String line =buff.readLine();
			while( line!= null){
				String[] part = line.split(",");
				InitContactParameter cont = new InitContactParameter().withFname(part[0]).withLname(part[1]).withAddress(part[2])
						.withHome(part[3]).withMobile(part[4]).withWork(part[5]).withEmail(part[6]).withEmail2(part[7]).withDay(part[8]).withMounth(part[9])
						.withYear(part[10]).withAdd2(part[11]).withPh2(part[12]);
				list.add(cont);
				line = buff.readLine();
			};
			buff.close();
			return list;
		}
	}

