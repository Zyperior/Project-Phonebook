/*
Robin Säfström ITHS 2018
 */
package phonebook.base;

public class ContactFactory {
	// parameters for minimum and maximum length of fields
	// edit these to conform with the the rest of the program
	// firstname min & max length
	private final static int fnMin = 2;
	private final static int fnMax = 20;
	// firstname min & max length
	private final static int lnMin = 2;
	private final static int lnMax = 20;
	// location min & max length
	private final static int lMin = 2;
	private final static int lMax = 20;
	// location min & max length
	private final static int pMin = 2;
	private final static int pMax = 20;

	// create a contact for swedish locale
	public static Contact createContact(String lastName, String firstName, String location, String phoneNumber) {

		// if regex regex doesnt match lastname for characters and length cast exception
		if (!lastName.matches("([a-zA-Z]|å|Å|ä|Ä|ö|Ö){" + lnMin + "," + lnMax + "}$")) {
			throw new IllegalArgumentException(
					"Ivalid input: Lastname," + lnMin + "-" + lnMax + ":chars, [a-ö] is valid");
		}
		// if regex regex doesnt match firstname for characters and length cast
		// exception
		if (!firstName.matches("([a-zA-Z]|å|Å|ä|Ä|ö|Ö){" + fnMin + "," + fnMax + "}$")) {
			throw new IllegalArgumentException(
					"Invalid input: Firstname," + fnMin + "-" + fnMax + ":chars, [a-ö] is valid");
		}
		// if regex regex doesnt match location for characters and length cast exception
		if (!location.matches("([a-zA-Z]|å|Å|ä|Ä|ö|Ö){" + lnMin + "," + lnMax + "}$")) {
			throw new IllegalArgumentException(
					"Invalid input: Location," + lnMin + "-" + lnMax + ":chars, [a-ö] is valid");
		}
		// if regex regex doesnt match phonenumber for characters and length cast
		// exception
		if (!phoneNumber.matches("([0-9]|-|){" + pMin + "," + pMax + "}$")) {
			throw new IllegalArgumentException(
					"Invalid input: Phonenumber," + lnMin + "-" + lnMax + ":chars, [0-9] & - is valid");
		}

		// return a new Contact object
		return new Contact(lastName, firstName, location, phoneNumber);
	}

}