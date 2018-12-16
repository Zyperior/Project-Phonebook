/* Date dd-mm-yyyy: 12-03-2018
 * Author: Gustav Ljungberg
*/

package phonebook.base;

import java.util.ArrayList;

import phonebook.base.tools.SearchAdressBook;
import phonebook.storage.StoreHandler;


public class AdressBook {

	//Fields
	StoreHandler sh = new StoreHandler();
	String category;
	ArrayList<Contact> contacts; // Stores all contacts
	
	/*
	 * Constructor taking an arrayList<Contact> as argument
	 * if not null the constructor instantiates an ArrayList based on the parameter
	 * else instantiates a new ArrayList. 
	 */
	
	//String constructor
	public AdressBook(String category) {
		this.category = category;
		contacts = sh.loadData(category);
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
	
	//removes selected contact from contacts arraylist
	public void removeContact(Contact contact) {
		contacts.remove(contact);
	}

	//Takes 4 strings as parameters. returns an araylist containing VisualContact objects
	public ArrayList<VisualContact> search(String lastName, String firstName, String location, String phoneNumber){
		return SearchAdressBook.searchContacts(contacts, lastName, firstName, location, phoneNumber);
	}
	
	//saves list to file using the filehandler field 
	public void save() {
		sh.saveData(contacts, category);
	}
	
	//Takes Contact as parameter. returns the index of the contact in the contacts arraylist
	//returns null if the contact doesn't exist 
	private Integer getIndexOf(Contact contact) {
		for (int i = 0; i < this.contacts.size(); i++) {
			if (this.contacts.get(i).hashCode() == contact.hashCode()) {
				return i;
			}
		}
		return null;
	}
	
	//checks if an Contact is in the contacts arraylist by comparing all Contact in contacts hashcode.
    //will return the contact that match the hashcode.
    //returns null if no contact match
	public Contact selectContact(Contact selectedContact) {
		if (selectedContact == null)
			throw new NullPointerException("Parameter selectedContact can't be null");
		for (Contact c : contacts) {
			if (c.hashCode() == selectedContact.hashCode()) return c;
		}
		System.err.println("selectedContact not ín contacts list!");
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
		
		if (contact.getPhoneNumber()==null) {
			throw new NullPointerException("ERROR! phoneNumber can not be null!");
		}else if (!contact.getPhoneNumber().getClass().equals(String.class)) {
			throw new IllegalArgumentException("ERROR! phoneNumber must be of type String");
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

	public String getUserName() {
		return category;
	}	
	
}