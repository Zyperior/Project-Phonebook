/*
Robin Säfström ITHS 2018
 */
package phonebook.base.tools;

import phonebook.base.Contact;

import java.util.Comparator;

public class SortByLocationComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact contact1, Contact contact2) {
		if (contact1 == null || contact2 == null) {
			throw new IllegalArgumentException("Unexpected null");
		}
		return contact1.getLocation().compareTo(contact2.getLocation());
	}

}
