/*
Robin Säfström ITHS 2018
 */
package phonebook.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ContactFactoryTest {

	// ensure that factory method doesnt accept nulls
	@Test
	public void testCreateContactNullExceptions() {

		String validLastName = "Andersson";
		String validName = "Jonas";
		String validLocation = "Sundsvall";
		String validPhoneNumber = "0701234567";

		// ensure that an exception is thrown if Lastname is null
		try {
			Contact c1 = ContactFactory.createContact(null, validName, validLocation, validPhoneNumber);
			fail("createContact() accepted null as lastName - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Firstname is null
		try {
			Contact c1 = ContactFactory.createContact(validLastName, null, validLocation, validPhoneNumber);
			fail("createContact() accepted null as firstName - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Location is null
		try {
			Contact c1 = ContactFactory.createContact(validLastName, validName, null, validPhoneNumber);
			fail("createContact() accepted null as location - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Phonenumber is null
		try {
			Contact c1 = ContactFactory.createContact(validLastName, validName, validLocation, null);
			fail("createContact() accepted null as phoneNumber - no exception thrown.");
		} catch (Exception e) {

		}

	}

	// ensure regex mismatches for too short inputs throws exceptions
	@Test
	public void testCreateContactRegexTooShortExceptions() {

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
			Contact c1 = ContactFactory.createContact(tooShortLastName, validName, validLocation, validPhoneNumber);
			fail("createContact() accepted null a too short String as lastName - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Firstname is too short
		try {
			Contact c1 = ContactFactory.createContact(validLastName, tooShortName, validLocation, validPhoneNumber);
			fail("createContact() accepted a too short String as as firstName - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Location is too short
		try {
			Contact c1 = ContactFactory.createContact(validLastName, validName, tooShortLocation, validPhoneNumber);
			fail("createContact() accepted a too short String as as location - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Phonenumber is too short
		try {
			Contact c1 = ContactFactory.createContact(validLastName, validName, validLocation, tooShortPhoneNumber);
			fail("createContact() accepted a too short String as as phoneNumber - no exception thrown.");
		} catch (Exception e) {

		}

	}

	// ensure regex mismatches for too long inputs throws exceptions
	@Test
	public void testCreateContactRegexTooLongExceptions() {

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
			Contact c1 = ContactFactory.createContact(tooLongLastName, validName, validLocation, validPhoneNumber);
			fail("createContact() accepted null a too long String as lastName - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Firstname is too long
		try {
			Contact c1 = ContactFactory.createContact(validLastName, tooLongName, validLocation, validPhoneNumber);
			fail("createContact() accepted a too long String as as firstName - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Location is too long
		try {
			Contact c1 = ContactFactory.createContact(validLastName, validName, tooLongLocation, validPhoneNumber);
			fail("createContact() accepted a too long String as as location - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Phonenumber is too long
		try {
			Contact c1 = ContactFactory.createContact(validLastName, validName, validLocation, tooLongPhoneNumber);
			fail("createContact() accepted a too long String as as phoneNumber - no exception thrown.");
		} catch (Exception e) {

		}

	}

	// ensure that invalid inputs throws exceptions
	@Test
	public void testCreateContactRegexExpressionsExceptions() {

		String validLastName = "Andersson";
		String invalidLastName = "!123Andersson";
		String validName = "Jonas";
		String invalidName = "?965?!Jonas";
		String validLocation = "Sundsvall";
		String invalidLocation = "S0nd5v411";
		String validPhoneNumber = "0701234567";
		String invalidPhoneNumber = "o7ol23a56?7";
		// ensure that an exception is thrown if Lastname contains characters outside of
		// the included range
		try {
			Contact c1 = ContactFactory.createContact(invalidLastName, validName, validLocation, validPhoneNumber);
			fail("createContact() accepted characters outside of the included range as lastName - no exception thrown.");
		} catch (Exception e) {

		}

		// ensure that an exception is thrown if Firstname contains characters outside
		// of the included range
		try {
			Contact c1 = ContactFactory.createContact(validLastName, invalidName, validLocation, validPhoneNumber);
			fail("createContact() accepted characters outside of the included range as firstName - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Location contains characters outside of
		// the included range
		try {
			Contact c1 = ContactFactory.createContact(validLastName, validName, invalidLocation, validPhoneNumber);
			fail("createContact() accepted characters outside of the included range as location - no exception thrown.");
		} catch (Exception e) {

		}
		// ensure that an exception is thrown if Phonenumber contains characters outside
		// of the included range
		try {
			Contact c1 = ContactFactory.createContact(validLastName, validName, validLocation, invalidPhoneNumber);
			fail("createContact() accepted characters outside of the included range as phoneNumber - no exception thrown.");
		} catch (Exception e) {

		}

	}

	// ensure that the factory creates an object equal to the same call to the
	// constructor
	@Test
	public void testCreateContactReturnedObject() {
		String validLastName = "Andersson";
		String validName = "Jonas";
		String validLocation = "Sundsvall";
		String validPhoneNumber = "0701234567";
		// object straight from the constructor we will use for the comparison
		Contact c1 = new Contact(validLastName, validName, validLocation, validPhoneNumber);
		// object created from the factory
		Contact c2 = ContactFactory.createContact(validLastName, validName, validLocation, validPhoneNumber);

		// verify that our factory created the object and doesnt manipulate the data

		assertEquals(c1.equals(c2), true);

	}

}