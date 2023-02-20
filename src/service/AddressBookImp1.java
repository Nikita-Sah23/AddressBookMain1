package service;

import java.util.Iterator;
import java.util.LinkedList;

import Model.Contacts;
import interfaces.IAddressBook;

public class AddressBookImp1 implements IAddressBook {
	
	private LinkedList<Contacts> ll = new LinkedList<Contacts>();

	@Override
	public int createContact(Contacts contacts) {
		ll.add(contacts);
		return 0;
	}

	@Override
	public void showAllContacts() {
	  for(Contacts i : ll)
		  System.out.println(i.toString());	  			
		}
		

	@Override
	public void search(String firstName) {
		for(Contacts i : ll)
		if(i.getFirstName() == firstName)
			System.out.println(i.toString());
	
		
	}

	@Override
	public void delete(String mobileNo) {
		for(Contacts i : ll)
			if (i.getPhoneNumber() == mobileNo)
				ll.remove(i);
		
	}


}
