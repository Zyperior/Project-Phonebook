/*
Robin Säfström ITHS 2018
 */
package phonebook.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

	// ensure that no nulls are accepted in the constructor
	@Test
	public void testConstructorNullExceptions() {

		String validLastName = "Andersson";
		String validName = "Jonas";
		String validLocation = "Sundsvall";
		String validPhoneNumber = "0701234567";

		// ensure that an exception is thrown if Lastname is null
		try {
			Contact c1 = new Contact(null, validName, validLocation, validPhoneNumber);
			fail("Constructor accepted null as lastName - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Firstname is null
		try {
			Contact c1 = new Contact(validLastName, null, validLocation, validPhoneNumber);
			fail("Constructor accepted null as firsName - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Location is null
		try {
			Contact c1 = new Contact(validLastName, validName, null, validPhoneNumber);
			fail("Constructor accepted null as location - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Phonenumber is null
		try {
			Contact c1 = new Contact(validLastName, validName, validLocation, null);
			fail("Constructor accepted null as phoneNumber - no exception thrown.");
		} catch (Exception e) {

		}

	}

	// ensure that no empty Strings are accepted in the constructor
	@Test
	public void testConstructorEmptyExceptions() {
		String validLastName = "Andersson";
		String validName = "Jonas";
		String validLocation = "Sundsvall";
		String validPhoneNumber = "0701234567";

		// ensure that an exception is thrown if Lastname is an empty String
		try {
			Contact c1 = new Contact("", validName, validLocation, validPhoneNumber);
			fail("Constructor accepted an empty String as lastName - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Firstname is an empty String
		try {
			Contact c1 = new Contact(validLastName, "", validLocation, validPhoneNumber);
			fail("Constructor accepted an empty String as firsName - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Location is an empty String
		try {
			Contact c1 = new Contact(validLastName, validName, "", validPhoneNumber);
			fail("Constructor accepted an empty String as location - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Phonenumber is an empty String
		try {
			Contact c1 = new Contact(validLastName, validName, validLocation, "");
			fail("Constructor accepted an empty String as phoneNumber - no exception thrown.");
		} catch (Exception e) {

		}
	}

	// ensure that no too short fields are accepted in the constructor
	@Test
	public void testConstructorFieldMinLengthExceptions() {
		String validLastName = "Andersson";
		String tooShortLastName = "a";
		String validName = "Jonas";
		String tooShortName = "b";
		String validLocation = "Sundsvall";
		String tooShortLocation = "c";
		String validPhoneNumber = "0701234567";
		String tooShortPhoneNumber = "1";

		// ensure that an exception is thrown if Lastname is too short
		try {
			Contact c1 = new Contact(tooShortLastName, validName, validLocation, validPhoneNumber);
			fail("Constructor accepted a too short String as lastName - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Firstname is too short
		try {
			Contact c1 = new Contact(validLastName, tooShortName, validLocation, validPhoneNumber);
			fail("Constructor accepted a too short String as firsName - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Location is too short
		try {
			Contact c1 = new Contact(validLastName, validName, tooShortLocation, validPhoneNumber);
			fail("Constructor accepted a too short String as location - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Phonenumber is too short
		try {
			Contact c1 = new Contact(validLastName, validName, validLocation, tooShortPhoneNumber);
			fail("Constructor accepted a too short String as phoneNumber - no exception thrown.");
		} catch (Exception e) {

		}
	}

	// ensure that no too long fields are accepted in the constructor
	@Test
	public void testConstructorFieldMaxLengthExceptions() {
		String validLastName = "Andersson";
		String tooLongLastName = "abcdefghijklmnopqrstuvwxyz";
		String validName = "Jonas";
		String tooLongName = "abcdefghijklmnopqrstuvwxyz";
		String validLocation = "Sundsvall";
		String tooLongLocation = "abcdefghijklmnopqrstuvwxyz";
		String validPhoneNumber = "0701234567";
		String tooLongPhoneNumber = "1234567891011121314151617";

		// ensure that an exception is thrown if Lastname is too long
		try {
			Contact c1 = new Contact(tooLongLastName, validName, validLocation, validPhoneNumber);
			fail("Constructor accepted a too long String as lastName - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Firstname is too long
		try {
			Contact c1 = new Contact(validLastName, tooLongName, validLocation, validPhoneNumber);
			fail("Constructor accepted a too long String as firsName - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Location is too long
		try {
			Contact c1 = new Contact(validLastName, validName, tooLongLocation, validPhoneNumber);
			fail("Constructor accepted a too long String as location - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Phonenumber is too long
		try {
			Contact c1 = new Contact(validLastName, validName, validLocation, tooLongPhoneNumber);
			fail("Constructor accepted a too long String as phoneNumber - no exception thrown.");
		} catch (Exception e) {

		}
	}

	// ensure that the getters returns the correct data
	// getters for names and location should return a capitalized first letter
	@Test
	public void testGettersIntegrity() {
		String validLastName = "andersson";
		String validCapLastName = "Andersson";
		String validName = "jonas";
		String validCapName = "Jonas";
		String validLocation = "sundsvall";
		String validCapLocation = "Sundsvall";
		String validPhoneNumber = "0701234567";

		Contact c1 = new Contact(validLastName, validName, validLocation, validPhoneNumber);
		// test getter for lastname
		assertEquals(c1.getLastName(), validCapLastName);
		// test getter for firstname
		assertEquals(c1.getFirstName(), validCapName);
		// test getter for location
		assertEquals(c1.getLocation(), validCapLocation);
		// test getter for phonenumber
		assertEquals(c1.getPhoneNumber(), validPhoneNumber);

		// test custom getter switch for gui

		// test case 0
		assertEquals(c1.getContactValueByIndex(0), validCapLastName);
		// test case 1
		assertEquals(c1.getContactValueByIndex(1), validCapName);
		// test case 2
		assertEquals(c1.getContactValueByIndex(2), validCapLocation);
		// test case 3
		assertEquals(c1.getContactValueByIndex(3), validPhoneNumber);
	}

	// ensure that the equals method can match objects
	@Test
	public void testEquals() {
		String validLastName = "Andersson";
		String validName = "Jonas";
		String validLocation = "Sundsvall";
		String validPhoneNumber = "0701234567";
		Contact c1 = new Contact(validLastName, validName, validLocation, validPhoneNumber);
		Contact c2 = new Contact(validLastName, validName, validLocation, validPhoneNumber);

		// verify that our objects equals the returned object
		assertEquals(c1.equals(c2), true);
	}

	// ensure that the toString returns the correct syntax
	@Test
	public void testToStringIntegrity() {

		String validLastName = "Andersson";
		String validName = "Jonas";
		String validLocation = "Sundsvall";
		String validPhoneNumber = "0701234567";
		String toStringEqualent = "Jonas,Andersson,Sundsvall,0701234567";
		Contact c1 = new Contact(validLastName, validName, validLocation, validPhoneNumber);

		// verify that our toString returns the correct syntax
		assertEquals(c1.toString(), toStringEqualent);
	}

}