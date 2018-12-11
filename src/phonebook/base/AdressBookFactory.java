package phonebook.base;

import java.util.ArrayList;

public class AdressBookFactory {

	public static AdressBook createAdressBook(ArrayList<Contact> contacts, String userName) {
		
		return new AdressBook(contacts, userName);
	}
}
