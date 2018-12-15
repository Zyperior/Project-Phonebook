/*
Robin Säfström ITHS 2018
 */
package phonebook.base.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import phonebook.base.Contact;

public class SortByLocationComparatorTest {

	// ensure that the comparator method wont try to compare nulls
	@Test
	public void testComparatorNullException() {
		try {
			SortByLocationComparator locationComparator = new SortByLocationComparator();
			locationComparator.compare(null, null);
			fail("Comparator method for location accepted null as input");
		} catch (Exception e) {

		}

	}

	// ensure that the comparator returns the correct order based on lastname
	@Test
	public void testComparatorLastName() {

		String validLastName = "Andersson";
		String validName = "Jonas";
		String firstValidLocation = "Akalla";
		String secondValidLocation = "Bohus";
		String validPhoneNumber = "0701234567";

		Contact c1 = new Contact(validLastName, validName, firstValidLocation, validPhoneNumber);
		Contact c2 = new Contact(validLastName, validName, secondValidLocation, validPhoneNumber);

		SortByLocationComparator locationNameComparator = new SortByLocationComparator();

		// ensure the method returns the correct order
		assertEquals(locationNameComparator.compare(c1, c2), -1);
		assertEquals(locationNameComparator.compare(c2, c1), 1);

	}
}
