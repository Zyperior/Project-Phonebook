/*
Robin Säfström ITHS 2018
 */

package phonebook.base;

public class Contact implements java.io.Serializable {

	private static final long serialVersionUID = -3360942794070127179L;
	private String firstName;
	private String lastName;
	private String location;
	private String phoneNumber;

	// parameters for minimum and maximum length of fields
	// edit these to conform with the the rest of the program
	// firstname min & max length
	private final int fnMin = 2;
	private final int fnMax = 20;
	// firstname min & max length
	private final int lnMin = 2;
	private final int lnMax = 20;
	// location min & max length
	private final int lMin = 2;
	private final int lMax = 20;
	// location min & max length
	private final int pMin = 2;
	private final int pMax = 20;

	public Contact(String lastName, String firstName, String location, String phoneNumber) {

		// nullcheck
		if (firstName == null || lastName == null || location == null || phoneNumber == null) {
			throw new IllegalArgumentException("No nulls allowed!");
		}
		// empty check
		if (firstName.isEmpty() || lastName.isEmpty() || location.isEmpty() || phoneNumber.isEmpty()) {
			throw new IllegalArgumentException("No empty fields allowed!");
		}
		// range check min values
		if (firstName.length() < fnMin || lastName.length() < lnMin || location.length() < lMin
				|| phoneNumber.length() < pMin) {
			throw new IllegalArgumentException("Input out of range!");
		}
		// range check max values
		if (firstName.length() > fnMax || lastName.length() > lnMax || location.length() > lMax
				|| phoneNumber.length() > pMax) {
			throw new IllegalArgumentException("Input out of range!");
		}

		// format data and store it
		// makes text fields lower case and capitalizing the first letter
		firstName = firstName.toLowerCase();
		lastName = lastName.toLowerCase();
		location = location.toLowerCase();
		this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
		this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
		this.location = location.substring(0, 1).toUpperCase() + location.substring(1);
		this.phoneNumber = phoneNumber;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLocation() {
		return location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// custom getter used by search method
	public String getContactValueByIndex(int index) {

		switch (index) {
		case 0:
			return lastName;

		case 1:
			return firstName;

		case 2:
			return location;

		case 3:
			return phoneNumber;
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Contact other = (Contact) obj;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;

		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;

		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;

		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;

		return true;
	}

	@Override
	// placeholder syntax feel free to request functionality
	public String toString() {
		return String.format("%s,%s,%s,%s", firstName, lastName, location, phoneNumber);
	}

}