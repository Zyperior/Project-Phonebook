package phonebook.base;

import java.util.ArrayList;

public class AdressBookFactory {

	public static AdressBook createAdressBook(String category) {
		
		return new AdressBook(category);
	}
}
