/*
Robin Säfström ITHS 2018
 */
package phonebook.base.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import phonebook.base.Contact;

public class SortByFirstNameComparatorTest {

	// ensure that the comparator method wont try to compare nulls
	@Test
	public void testComparatorNullException() {
		try {
			SortByFirstNameComparator firstNameComparator = new SortByFirstNameComparator();
			firstNameComparator.compare(null, null);
			fail("Comparator method for firstName accepted null as input");
		} catch (Exception e) {

		}

	}

	// ensure that the comparator returns the correct order based on firstname
	@Test
	public void testComparatorFirstName() {

		String validLastName = "Andersson";
		String firstValidName = "Ada";
		String secondValidName = "Babbas";
		String validLocation = "Sundsvall";
		String validPhoneNumber = "0701234567";

		Contact c1 = new Contact(validLastName, firstValidName, validLocation, validPhoneNumber);
		Contact c2 = new Contact(validLastName, secondValidName, validLocation, validPhoneNumber);

		SortByFirstNameComparator firstNameComparator = new SortByFirstNameComparator();

		// ensure the method returns the correct order
		assertEquals(firstNameComparator.compare(c1, c2), -1);
		assertEquals(firstNameComparator.compare(c2, c1), 1);

	}

}
