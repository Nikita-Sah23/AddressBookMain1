package interfaces;


import Model.Contacts;

public interface IAddressBook {
	
	int createContact(Contacts  contacts);
	void showAllContacts();
	void search(String firstName);
	void delete(String mobileNo);
	
}
