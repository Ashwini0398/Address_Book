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
	
	static Person editPersonDetails(Person person) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Address");
		person.address = sc.next();
		System.out.println("Enter the City");
		person.city = sc.next();
		System.out.println("Enter the State");
		person.state = sc.next();
		System.out.println("Enter the ZipCode");
		person.zipCode = sc.nextInt();
		System.out.println("Enter the contact number...");
		person.phoneNumber = sc.next();
		return person;

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
					
				case 2:
					System.out.println("Edit the person details");
					String Firstname= sc.next();
					if(Firstname.equals(person.firstName))
					{
						person=editPersonDetails(person);
					}
					else
					{
						System.out.println(Firstname+" Invaild entry ");
					}
					System.out.println(person);
					break;

				default:
					System.out.println("Enter valid number");
				}
			}
			  
	}
}
