package phonebook.base;

import java.util.ArrayList;

//Factory for AdressBook objects 
//Takes a string and returns a new AdressBook
public class AdressBookFactory {

	public static AdressBook createAdressBook(String category) {
		
		return new AdressBook(category);
	}
}
