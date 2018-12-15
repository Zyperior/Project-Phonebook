/*
Robin Säfström ITHS 2018
 */
package phonebook.base.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import phonebook.base.Contact;

public class SortTest {

	// ensure the sorting works
	@Test
	public void testCreateContactReturnedObject() {
		// list to be sorted
		ArrayList<Contact> sArr = new ArrayList<Contact>();

		// presorted list for reference
		ArrayList<Contact> rArr = new ArrayList<Contact>();

		// lastnames
		String firstValidLastName = "Abbedal";
		String secondValidLastName = "Accedal";
		String thirdValidLastName = "Babbedal";
		String fourthValidLastName = "Baccedal";
		String fifthValidLastName = "Caccedal";
		String sixthValidLastName = "Caddedal";
		// firstnames
		String firstValidName = "Ada";
		String secondValidName = "Birger";
		String thirdValidName = "Camilla";
		// locations
		String firstValidLocation = "Ale";
		String secondValidLocation = "Bohus";

		String validPhoneNumber = "0701234567";

		Contact c1 = new Contact(firstValidLastName, thirdValidName, firstValidLocation, validPhoneNumber);
		Contact c2 = new Contact(secondValidLastName, firstValidName, secondValidLocation, validPhoneNumber);
		Contact c3 = new Contact(thirdValidLastName, secondValidName, firstValidLocation, validPhoneNumber);
		Contact c4 = new Contact(fourthValidLastName, firstValidName, secondValidLocation, validPhoneNumber);
		Contact c5 = new Contact(fifthValidLastName, thirdValidName, firstValidLocation, validPhoneNumber);
		Contact c6 = new Contact(sixthValidLastName, secondValidName, secondValidLocation, validPhoneNumber);

		// populate the reference list
		rArr.add(c2);
		rArr.add(c4);
		rArr.add(c3);
		rArr.add(c6);
		rArr.add(c1);
		rArr.add(c5);

		// populate the list to be sorted
		sArr.add(c5);
		sArr.add(c1);
		sArr.add(c2);
		sArr.add(c6);
		sArr.add(c3);
		sArr.add(c4);

		// compare the sorted list to our reference
		assertEquals(Sort.sort(sArr), rArr);

	}

}
