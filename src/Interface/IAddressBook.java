package Interface;

import Model.Contacts;
import exception.InvalidMobileNumberException;
import exception.StartWithCapitalLetterException;

public interface IAddressBook {
	
	int createContact(Contacts contacts) throws InvalidMobileNumberException, StartWithCapitalLetterException;
	void showAllContacts();
	void search(String firstName);
	void delete(long mobileNo);

}
