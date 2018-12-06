/* Date dd-mm-yyyy: 12-03-2018
 * Author: Gustav Ljungberg
*/

package phonebook.base;

import java.util.ArrayList;


public class AdressBook {

	/*
	 * contacts field is a list that contains Contact objects.
	 * adding it as an Arraylist for now
	 */
	ArrayList<Contact> contacts;
	
	/*
	 * Constructor taking an arrayList<Contact> as argument
	 * if not null the constructor instantiates an ArrayList based on the parameter
	 * else instantiates a new ArrayList. 
	 */
	public AdressBook(ArrayList<Contact> contacts) {
		if (verifyContactArray(contacts)) {
			this.contacts = new ArrayList<>(contacts);
		}else {
			this.contacts = new ArrayList<>();
		}
	}	
	/*
	 * no args constructor
	 * initializes contacts list
	 */
	public AdressBook() {
		this.contacts = new ArrayList<>();
	}

	
	/*
	 * adds a Contact object to the arraylist contacts if the Contact object is successfully verified
	 */
	public void addContact(Contact contact) {
		if (verifyContactObject(contact)) {
			this.contacts.add(contact);
		}
	}
	
	//(in progress)
	//This method removes selected contact from contacts arraylist
	public void removeContact() {
		
	}
	
	//(in progress)
	//searches for Contact/contacts using phoneNumber, firstName, LastName, location.
	//returns an arraylist containing all contacts matching the search terms
//	public ArrayList<VisualContact> searchContacts(String lastName, String firstName, String location, String phonenumber) {
//		
//		String[] searchTerms = {firstName, lastName, location, phonenumber};
//
//		ArrayList<Integer> fieldVar = new ArrayList<>();
//		
////		if (firstName.length() > 0 && firstName != null) { 
////			searchTerms.add(firstName);
////			fieldVar.add(0);
////			
////		if (lastName.length() > 0 && lastName != null) { 
////			searchTerms.add(lastName);
////			fieldVar.add(1);
////		}
////	}
////		if (location.length() > 0 && location != null) {
////			searchTerms.add(location);
////			fieldVar.add(2);
////		}
////		if (phonenumber.length() > 0 && phonenumber != null) { 
////			searchTerms.add(phonenumber);
////			fieldVar.add(3);
////		}
//		
//		ArrayList<VisualContact> searchResult = new ArrayList<>();
//		
//		for (Contact c : this.contacts) {
//			int matches = 0;
//			
//			for (int i = 0; i < searchTerms.length; i++) {
//				String[] fields = c.toString().split(",");
//				if (searchTerms[i] == null) {
//					System.out.println("asdf+8745");
//				}
//				if (searchTerms[i].length() < 1 || searchTerms[i] == null) {
//					matches++;
//					continue;
//				}else {
//					searchTerms[i]=searchTerms[i].toLowerCase();
//				if (c.toString().toLowerCase().contains(searchTerms[i])) {
//					System.out.println(searchTerms[i] + " exists");
//					matches++;
//					}
//					System.out.println("Matches: " + matches);
//				if (matches == searchTerms.length) {
//					searchResult.add(new VisualContact(c));
//				}}
//			}
//		}
//		return searchResult;
//	}	
	
	//(in progress)
	//selects a Contact object from search result
	public Contact selectContact() {
		return null;
	}
	
	
	
	
	
	/*
	 * returns a String featuring Contact.toString() of all Contact objects in the ArrayList contacts.
	 * If contacts have not yet been initialized, toString will return null.
	 */
	@Override
	public String toString() {
		String contactList = null; 
		if (verifyContactArray(contacts)) {
			contactList = "";
			for (Contact c : contacts) {
				contactList += c.toString() + "\n";
			}
		}
		return contactList;
	}
	/*
	 * Verifies that an arrayList containing contacts does not equal to null
	 * returns true if not equal to null.
	 */
	private boolean verifyContactArray(ArrayList<Contact> contacts) {
		if (contacts != null) {
			return true;
		}else {
			return false;
		}
	}

	 /*
	  * Verifies that an Contact object and fields is not equal to null and that the fields are of correct type
	  * the method throws an exception if any Contact or fields is null or any of the fields are of invalid types 
	  * returns true if there isn't any exceptions 
	  */
	private boolean verifyContactObject(Contact contact) {
		
		if (contact == null) {
			throw new NullPointerException("ERROR! Contact can not null!");
		}
		
		if (contact.getFirstName()==null) {
			throw new NullPointerException("ERROR! firstName can not be null!");
		}else if(!contact.getFirstName().getClass().equals(String.class)){
			throw new IllegalArgumentException("ERROR! firstName must be a String");
		}
		
		if (contact.getLastName()==null) {
			throw new NullPointerException("ERROR! lastName can not be null!");
		}else if(!contact.getLastName().getClass().equals(String.class)){
			throw new IllegalArgumentException("ERROR! lastName must be a String");
		}
		
		if (contact.getCellPhoneNumber()==null) {
			throw new NullPointerException("ERROR! cellPhoneNumber can not be null!");
		}else if (!contact.getCellPhoneNumber().getClass().equals(String.class)) {
			throw new IllegalArgumentException("ERROR! cellPhoneNumber must be of type String");
		}
		
		if (contact.getLocation()==null) {
			throw new NullPointerException("ERROR! location can not be null!");
		}else if (!contact.getLocation().getClass().equals(String.class)) {
			throw new IllegalArgumentException("ERROR! location must be of type String");
		}else {
			return true;
		}
	}
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}	
	
}