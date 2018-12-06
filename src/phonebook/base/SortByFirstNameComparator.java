package phonebook.base;

import java.util.Comparator;

class SortByFirstNameComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact contact1, Contact contact2) {

		return contact1.getFirstName().compareTo(contact2.getFirstName());
	}

}
