/*
Robin Säfström ITHS 2018

Two step sort
1. sort by firstname
2. sort by lastname

 How to use? your_arrayList = Sort.sort(your_arrayList);
 *
 */
package phonebook.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {

	public static ArrayList<Contact> sort(ArrayList<Contact> arr) {
		Collections.sort(arr, new SortByFirstNameComparator().thenComparing(new SortByLastNameComparator()));
		return arr;
	}

}

class SortByFirstNameComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact contact1, Contact contact2) {

		return contact1.getFirstName().compareTo(contact2.getFirstName());
	}

}

class SortByLastNameComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact contact1, Contact contact2) {

		return contact1.getLastName().compareTo(contact2.getLastName());
	}

}
