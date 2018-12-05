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
	//searches for specifik Contact/contacts using phoneNumber, firstName, LastName.
	//returns an arraylist containing all contacts matching the search terms
	public ArrayList<Contact> searchContacts() {

		return null;
	}
	
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
				contactList += c.toString();
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
	  * Verifies that an Contact object is not equal to null and that the fields are of correct type
	  * This method assumes that Contact fields use the following types firstName:String, lastName:String, phoneNumber:int.
	  * the method throws an exception if any Contact is null or any of the fields are of invalid types 
	  * returns true if there isn't any exceptions
	  * is currently commented out to not cause compile error. 
	  */
	 private boolean verifyContactObject(Contact contact) {
//		 Number n;
//		 if (contact == null) {
//			 throw new NullPointerException("ERROR! Contact can not null!");
//			 return false;
//		 }if (contact.getPhoneNumber != null) {
//			 n = contact.getPhoneNumber();
//		 }
//		 if(!contact.getFirstName().getClass().equals(String.class)){
//			 throw new Exception("ERROR! firstName must be a String");
//		 }else if(!contact.getLastName().getClass().equals(String.class)){
//			 throw new Exception("ERROR! lastName must be a String");
//		 }else if (!Integer.class.equals(contact.getPhoneNumber().getClass())) {
//			 throw new Exception("ERROR! phoneNumber must be of type int");
//		 }else {
			 return true;
		 }
//	 }
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}	
	
}