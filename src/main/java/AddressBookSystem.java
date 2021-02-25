import java.util.*;

class AddressBookSystem {
    public static Scanner sc = new Scanner(System.in);
    private static AddressBookMain addressBook = new AddressBookMain();
    public Map<String, AddressBookMain> multipleAddressBook = new HashMap<>();

    public void addAddressBook(String bookName) {
        if (multipleAddressBook.containsKey(bookName)) {
            System.out.println("The Address book Already Exists");
        } else {
            multipleAddressBook.put(bookName, addressBook);
            addressBook.addContactDetails();
        }
    }

    public void editAddressBook() {

        System.out.println("Enter the Person First name to edit details: ");
        String personName = sc.next();

        boolean dataEdited = addressBook.editContactDetails(personName);
        if (dataEdited) {
            System.out.println("List Edited Successfully in the address book");
        } else {
            System.out.println("List Cannot be Edited");
        }

    }

    public void deleteAddressBook() {

        System.out.println("Enter the Person First name to delete the details: ");
        String personName = sc.next();

        boolean dataDeleted = addressBook.deleteContact(personName);
        if (dataDeleted ){
            System.out.println("Address book deleted Successfully ");
        } else {
            System.out.println("Address book Cannot be deleted");
        }

    }

    public void sortPersonByStateName(String stateName)
    {
        for(Map.Entry<String,AddressBookMain> entry: multipleAddressBook.entrySet())
        {
            AddressBookMain value = entry.getValue();
            System.out.println("The Address Book:"+entry.getKey());
            value.getPersonNameByState(stateName);
        }

    }

    public void sortPersonByCityName(String cityName)
    {
        for(Map.Entry<String,AddressBookMain> entry: multipleAddressBook.entrySet())
        {
            AddressBookMain value = entry.getValue();
            System.out.println("The Address Book:"+entry.getKey());
            value.getPersonNameByState(cityName);
        }

    }

    public void viewPersonByStateName(String stateName)
    {
        for(Map.Entry<String,AddressBookMain> entry : multipleAddressBook.entrySet())
        {
            AddressBookMain value = entry.getValue();
            ArrayList<Person> personArrayList = value.personByState.entrySet()
                                                                    .stream().filter(findState ->findState.getKey().equals(stateName))
                                                                    .map(Map.Entry::getValue).findFirst()
                                                                    .orElse(null);
            for(Person person: personArrayList)
            {
                System.out.println("First Name:"+person.getFirstName());
                System.out.println("Last Name:"+person.getLastName());
            }
        }
    }

    public void viewPersonByCityName(String cityName)
    {
        for(Map.Entry<String,AddressBookMain> entry : multipleAddressBook.entrySet())
        {
            AddressBookMain value = entry.getValue();
            ArrayList<Person> personArrayList = value.personByCity.entrySet()
                    .stream().filter(findCity ->findCity.getKey().equals(cityName))
                    .map(Map.Entry::getValue).findFirst()
                    .orElse(null);
            for(Person person: personArrayList)
            {
                System.out.println("First Name:"+person.getFirstName());
                System.out.println("Last Name:"+person.getLastName());
            }
        }
    }
    public void displayAddressBook()
    {
        for(String i: multipleAddressBook.keySet())
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Management System using Java Stream");
        AddressBookSystem addressBookSystem = new AddressBookSystem();

        while (true) {
            System.out.println("1.Add New Address Book");
            System.out.println("2.Edit the address book ");
            System.out.println("3.Delete the address book");
            System.out.println("4.Sort the address book by State Name");
            System.out.println("5.Sort the address book By City Name");
            System.out.println("6.view the person details by State Name");
            System.out.println("7.view the person details by City Name");
            System.out.println("8.Display");
            System.out.println("9.Exit");

            System.out.println("Enter choice: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the Name of Address Book to add: ");
                    String addressBookName = sc.next();
                    addressBookSystem.addAddressBook(addressBookName);
                    break;
                case 2:
                    System.out.println("Enter the Name of Address Book to edit : ");
                    String addressBookName1 = sc.next();
                    if (addressBookSystem.multipleAddressBook.containsKey(addressBookName1)) {
                        addressBookSystem.editAddressBook();
                    } else {
                        System.out.println("AddressBook cannot be edited");

                    }
                    break;
                case 3:
                    System.out.println("Enter the Name of Address Book to delete: ");
                    String addressBookName2 = sc.next();
                    if (addressBookSystem.multipleAddressBook.containsKey(addressBookName2)) {

                        addressBookSystem.deleteAddressBook();
                    }
                    else
                    {
                        System.out.println("Address book cannot be deleted");
                    }
                    break;
                case 4:
                    System.out.println("Enter the State Name: ");
                    String stateName = sc.next();
                    addressBookSystem.sortPersonByStateName(stateName);
                    break;

                case 5:
                    System.out.println("Enter the City Name: ");
                    String cityName= sc.next();
                    addressBookSystem.sortPersonByCityName(cityName);
                    break;

                case 6:
                    System.out.println("Enter the State Name to view : ");
                    String stateNameView = sc.next();
                    addressBookSystem.sortPersonByStateName(stateNameView);
                    break;
                case 7:
                    System.out.println("Enter the city Name to view: ");
                    String cityNameView = sc.next();
                    addressBookSystem.sortPersonByStateName(cityNameView);
                    break;

                case 8: {
                    addressBookSystem.displayAddressBook();

                    break;
                }
                case 9: {
                        System.exit(1);
                        break;
                    }
            }
        }
    }
}




