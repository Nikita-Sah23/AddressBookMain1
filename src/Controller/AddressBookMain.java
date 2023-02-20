package Controller;

import java.util.Scanner;
import interfaces.IAddressBook;
import Model.Contacts;
import exception.InvalidMobileNumberException;
import exception.StartWithCapitalLetterException;
import service.AddressBookImp1;

import java.util.*;

public class AddressBookMain {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
	
		int i = 0;
		IAddressBook addressBook = (IAddressBook) new AddressBookImp1();
		do {
			System.out.println("1 Create Contact");
			System.out.println("2 See All Contacts");
			System.out.println("3 update Contact (using mobile number)");
			System.out.println("4 Delete Contact (using mobile number)");
			System.out.println("5 Search Contact (using first or last names)");
			System.out.println("Enter you choice...");
			int ch = SCANNER.nextInt();

			switch (ch) {
			case 1:
				System.out.println("creating contact...");
				Contacts contacts = getContacts();
				int index = 0;
				try {
					index = addressBook.createContact(contacts);
				}catch (InvalidMobileNumberException e) {
					System.out.println(e);
					System.out.println("Enter the valid mobile number");
					String m = SCANNER.next();
					contacts.setPhoneNumber(m);
					index = addressBook.createContact(contacts);
				}catch (StartWithCapitalLetterException e) {
					System.out.println(e);
					System.out.println("Please Enter firstName");
					String f = SCANNER.next();
					contacts.setFirstName(f);
					index = addressBook.createContact(contacts);
				}
				System.out.println("Contacts id ="+index);
				break;

			case 2:	addressBook.showAllContacts();
			break;

			case 4: System.out.println("Enter the mobile number to delete...");
			String mobileNumber = SCANNER.next();
			addressBook.delete(mobileNumber);
			break;

			case 5: System.out.println("Enter the first name to search...");
			String firstName = SCANNER.next();
			addressBook.search(firstName);
			break;
			default:
				System.out.println("Invalid choice...");
				break;
			}

			System.out.println("Do you want to contineu...press 1");
			i = SCANNER.nextInt();
		}while(i==1);
	}

	private static Contacts getContacts() {
		Contacts contacts = new Contacts();
		System.out.println("Enter First Name");
		String firstName = SCANNER.next();
		contacts.setFirstName(firstName);

		System.out.println("Enter Last Name");
		String lastName = SCANNER.next();
		contacts.setLastName(lastName);
		
		System.out.println("Enter Mobile Number");
		String mobileNumber = SCANNER.next();
		contacts.setPhoneNumber(mobileNumber);
		return contacts;
	}
}


