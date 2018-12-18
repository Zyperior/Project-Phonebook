/*
Robin Säfström ITHS 2018

Three step sort
1. sort by firstname
2. sort by lastname
3. sort by location
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
		
		try {
		Collections.sort(arr, new SortByFirstNameComparator()
				.thenComparing(new SortByLastNameComparator().thenComparing(new SortByLocationComparator())));
		}
		catch(Exception e) {
			System.err.println("A null was sent to the comparator, the software is either compromised or your computer has io/ram issues.");
			System.exit(0);
		}
		
		
		return arr;
	}

}