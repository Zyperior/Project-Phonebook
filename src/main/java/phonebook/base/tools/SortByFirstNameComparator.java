package phonebook.base.tools;

import phonebook.base.Contact;

import java.util.Comparator;

public class SortByFirstNameComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact contact1, Contact contact2) {

		return contact1.getFirstName().compareTo(contact2.getFirstName());
	}

}
