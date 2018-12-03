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
	 * no args constructor
	 * initializes contacts list
	 */
	public AdressBook() {
		this.contacts = new ArrayList<>();
	}
	
	
	
}
