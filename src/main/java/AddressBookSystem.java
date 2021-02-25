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
            System.out.println("4.Display");
            System.out.println("5.Exit");

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

                case 4: {
                    addressBookSystem.displayAddressBook();
                    ;
                    break;
                }
                case 5: {
                        System.exit(0);
                        break;
                    }
            }
        }
    }
}




