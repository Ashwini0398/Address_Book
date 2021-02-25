import java.util.*;

public class AddressBookMain {

    public static Scanner sc = new Scanner(System.in);
    public ArrayList<Person> contactList = new ArrayList<>();

    public void addContactDetails(){
        System.out.println("Enter the Details of ContactDetails");
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
        System.out.println("Enter the email");
        String email = sc.next();
        System.out.println("Enter the ZipCode");
        String zip = sc.next();
        System.out.println("Enter the contact number...");
        String phoneNumber = sc.next();
        Person person = new Person(firstName, lastName, address, city, state, email, phoneNumber, zip);
        contactList.add(person);

    }

    public boolean editContactDetails(String Name) {
        int flag = 0;
        for(Person contact: contactList)
        {
            if(contact.getFirstName().equals(Name))
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Address: ");
                String address = sc.next();
                contact.setAddress(address);
                System.out.println("Enter City: ");
                String city = sc.next();
                contact.setCity(city);
                System.out.println("Enter State: ");
                String state = sc.next();
                contact.setState(state);
                System.out.println("Enter Email: ");
                String email = sc.next();
                contact.setEmail(email);
                System.out.println("Enter Phone Number:");
                String phoneNumber = sc.next();
                contact.setPhoneNumber(phoneNumber);
                System.out.println("Enter Zip Code: ");
                String zip = sc.next();
                contact.setZip(zip);
                flag = 1;
            }
        }
        return flag == 1;
    }
    public boolean deleteContact(String name) {
        int flag = 0;
        for(Person contact: contactList)
        {
            if(contact.getFirstName().equals(name))
            {
                contactList.remove(contact);
                flag = 1;
                break;
            }
        }
        return flag == 1;
    }


}




