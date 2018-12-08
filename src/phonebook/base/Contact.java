/*
Robin Säfström ITHS 2018
 */

package phonebook.base;

public class Contact {
	private String firstName;
	private String lastName;
	private String location;
	private String cellPhoneNumber;

	public Contact(String firstName, String lastName, String location, String cellPhoneNumber) {

		// nullcheck
		if (firstName == null || lastName == null || location == null || cellPhoneNumber == null) {
			throw new IllegalArgumentException("No nulls allowed!");
		}

		// empty check
		if (firstName.isEmpty() || lastName.isEmpty() || location.isEmpty() || cellPhoneNumber.isEmpty()) {
			throw new IllegalArgumentException("No empty fields allowed!");
		}
		// range check
		if (firstName.length() > 20 || lastName.length() > 20 || location.length() > 20
				|| cellPhoneNumber.length() > 15) {
			throw new IllegalArgumentException("Input out of range!");
		}

		// we dodged all exceptions! hurrray!
		firstName = firstName.toLowerCase();
		lastName = lastName.toLowerCase();
		location = location.toLowerCase();
		this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
		this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
		this.location = location.substring(0, 1).toUpperCase() + location.substring(1);
		this.cellPhoneNumber = cellPhoneNumber;

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

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public String getContactValueByIndex(int index) {

		switch(index){
			case 0:
				return lastName;

			case 1:
				return firstName;

			case 2:
				return location;

			case 3:
				return cellPhoneNumber;
		}
		 return null;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellPhoneNumber == null) ? 0 : cellPhoneNumber.hashCode());
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
		if (cellPhoneNumber == null) {
			if (other.cellPhoneNumber != null)
				return false;
		} else if (!cellPhoneNumber.equals(other.cellPhoneNumber))
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
		return String.format("%s,%s,%s,%s", firstName, lastName, location, cellPhoneNumber);
	}

}