package com.book;

import java.util.*;

public class AddressBookMain {

	ArrayList<Person> al=null;
	AddressBookMain(){
		al=new ArrayList();
	}
	Scanner sc = new Scanner(System.in);
	Person person=null;
	
	public void getDataFromConsole() {
		
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

		al.add( new Person(firstName, lastName, address, city, state, zipCode, phoneNumber));
	}
	
	public void editPersonDetails(Person person) {
		

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
	}
	
	public void deletePersonDetails(Person person)
	{
		
		String Firstname1= sc.next();
		ArrayList<Person> personlist1 = al;
		for (int i=0; i<personlist1.size();i++)
		{
			if(personlist1.get(i).firstName.equals(Firstname1))
			{
				
				personlist1.remove(i);
			}
		}
	}

	public static void main(String[] args) {
	
			AddressBookMain ab = new AddressBookMain();
			int choice;
			 while(true)
			 {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter ur choice press 1 For Add person  ");
				choice = sc.nextInt();
				switch (choice) {

				case 1:
					ab.getDataFromConsole();
					break;
					
				case 2:
					System.out.println("Edit the person details");
					String Firstname= sc.next();
					ArrayList<Person> personlist = ab.al;
					for (int i=0; i<personlist.size();i++)
					{
						if(personlist.get(i).firstName.equals(Firstname))
						{
							
							Person p = personlist.get(i);
							ab.editPersonDetails(p);
						}
										{
						System.out.println(Firstname+" Invaild entry ");
						}
					}
					break;

				case 3:
			
					ab.deletePersonDetails();
					break;
					
				case 4:
					System.out.println(person);
					break;
					

				default:
					System.out.println("Enter valid number");
				}
			}
			  
	}
}
