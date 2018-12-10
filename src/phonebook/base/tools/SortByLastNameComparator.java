package phonebook.base.tools;

import java.util.Comparator;

public class SortByLastNameComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact contact1, Contact contact2) {

		return contact1.getLastName().compareTo(contact2.getLastName());
	}

}
