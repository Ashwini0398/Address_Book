package com.book;

import java.util.*;

public class AddressBookMain {
	
	static Person getDataFromConsole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Details of Person");
		System.out.println("Enter the first name");
		String firstName = sc.next();
		System.out.println("Enter the Last name");
		String lastName = sc.next();
		System.out.println("Enter the Address");
		String address = sc.next();
		System.out.println("Enter the City");
		String city = sc.next();
		System.out.println("Enter the State");
		String state = sc.next();
		System.out.println("Enter the ZipCode");
		int zipCode = sc.nextInt();
		System.out.println("Enter the contact number...");
		String phoneNumber = sc.next();

		return new Person(firstName, lastName, address, city, state, zipCode, phoneNumber);
	}
	

	public static void main(String[] args) {
	
			Person person = getDataFromConsole(); //get the data from the console
			int choice;
			 while(true)
			 {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter ur choice press 1 For Add person  ");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					person = getDataFromConsole();
					break;
				default:
					System.out.println("Enter valid number");
				}
			}
			  
	}
}
