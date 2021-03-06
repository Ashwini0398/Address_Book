import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Person> contactList ;
    public HashMap<String,ArrayList<Person>> personByState;
    public HashMap<String,ArrayList<Person>> personByCity;

    public AddressBookMain()
    {
        personByState = new HashMap<String,ArrayList<Person>>();
        personByCity = new HashMap<String,ArrayList<Person>>();
        contactList =new ArrayList<>();
    }

    public ArrayList<Person> addContactDetails() {

        System.out.println(" Enter the Details of ContactDetails");
        System.out.println("Enter the first name");
        String firstName = sc.next();
        if (checkDuplicate(firstName)) {
            System.out.println("Person already exist");
        } else {
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
            if(!personByState.containsKey(state))
            {
                personByState.put(state,new ArrayList<Person>());
            }
            personByState.get(state).add(person);

            if(!personByCity.containsKey(city))
            {
                personByCity.put(city,new ArrayList<Person>());
            }
            personByCity.get(city).add(person);
        }
        return contactList;
    }

    public boolean editContactDetails(String Name) {
        int flag = 0;
        for (Person contact : contactList) {
            if (contact.getFirstName().equals(Name)) {
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
        for (Person contact : contactList) {
            if (contact.getFirstName().equals(name)) {
                contactList.remove(contact);
                flag = 1;
                break;
            }
        }
        return flag == 1;
    }


    public boolean checkDuplicate(String fname) {
        int flag = 0;
        for (Person p : contactList) {
            if (p.getFirstName().equals(fname)) {
                flag = 1;
                break;
            }
        }
        return flag == 1;
    }


    public void getPersonNameByState(String State)
    {
        List<Person> listOfPerson = contactList.stream()
                                                .filter(person -> person.getState().equals(State))
                                                .collect(Collectors.toList());
        for(Person person: listOfPerson)
        {
            System.out.println("First Name:"+person.getFirstName());
            System.out.println("Last Name:"+person.getLastName());

        }
    }

    public void getPersonNameByCity(String City)
    {

        List<Person> listOfPerson = contactList.stream()
                                            .filter(person -> person.getCity().equals(City))
                                            .collect(Collectors.toList());
        for(Person person: listOfPerson)
        {
            System.out.println("First Name:"+person.getFirstName());
            System.out.println("Last Name:"+person.getLastName());
        }
    }


    public void writePersonData(AddressBookSystem addressBookSystem) {
        StringBuffer personBuffer = new StringBuffer();
        contactList.forEach(person -> {
            String personDataString = person.toString().concat("\n");
            personBuffer.append(personDataString);
        });
        try {
            Files.write(Paths.get("F:\\personData.txt"), personBuffer.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void readPersonData( AddressBookSystem addressBookSystem) {
        try {
            Files.lines(new File("F:\\personData.txt").toPath())
                                                                    .map(String::trim)
                                                                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    // write data to CSV file
    public  static void writeDataToCSV() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try (Writer writer = Files.newBufferedWriter(Paths.get("F:\\personData.csv"));) {
            StatefulBeanToCsvBuilder<Person> builder = new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<Person> beanWriter = builder.build();
            beanWriter.write(contactList);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read data from CSV file
    public  static void readDataUsingCSV() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get("F:\\personData.csv"));
             CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("First Name - " + nextRecord[3]);
                System.out.println("Last Name - " + nextRecord[4]);
                System.out.println("Address - " + nextRecord[0]);
                System.out.println("City - " + nextRecord[1]);
                System.out.println("State - " + nextRecord[6]);
                System.out.println("Email - " + nextRecord[2]);
                System.out.println("Phone - " + nextRecord[5]);
                System.out.println("Zip - " + nextRecord[7]);
            }
        }
    }

}





