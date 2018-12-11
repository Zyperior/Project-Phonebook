/*
Robin Säfström ITHS 2018

Two step sort
1. sort by firstname
2. sort by lastname

 How to use? your_arrayList = Sort.sort(your_arrayList);
 *
 */
package phonebook.base.tools;

import phonebook.base.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {

	public static ArrayList<Contact> sort(ArrayList<Contact> arr) {
		Collections.sort(arr, new SortByFirstNameComparator().thenComparing(new SortByLastNameComparator().thenComparing(new SortByLocationComparator())));
		return arr;
	}

}
