/*
Robin Säfström ITHS 2018
 */
package phonebook.base.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import phonebook.base.Contact;

public class SortByLastNameComparatorTest {

	// ensure that the comparator method wont try to compare nulls
	@Test
	public void testComparatorNullException() {
		try {
			SortByLastNameComparator lastNameComparator = new SortByLastNameComparator();
			lastNameComparator.compare(null, null);
			fail("Comparator method for lastName accepted null as input");
		} catch (Exception e) {

		}

	}

	// ensure that the comparator returns the correct order based on lastname
	@Test
	public void testComparatorLastName() {

		String firstValidLastName = "Andersson";
		String secondValidLastName = "Babelvik";
		String validName = "Jonas";
		String validLocation = "Sundsvall";
		String validPhoneNumber = "0701234567";

		Contact c1 = new Contact(firstValidLastName, validName, validLocation, validPhoneNumber);
		Contact c2 = new Contact(secondValidLastName, validName, validLocation, validPhoneNumber);

		SortByLastNameComparator lastNameComparator = new SortByLastNameComparator();

		// ensure the method returns the correct order
		assertEquals(lastNameComparator.compare(c1, c2), -1);
		assertEquals(lastNameComparator.compare(c2, c1), 1);

	}

}
