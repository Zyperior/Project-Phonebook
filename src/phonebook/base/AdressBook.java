/* Date dd-mm-yyyy: 12-03-2018
 * Author: Gustav Ljungberg, Andreas Albihn
*/

package phonebook.base;

import java.util.ArrayList;


public class AdressBook {

	

	String userName;
	ArrayList<Contact> contacts; // Stores all contacts
	
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
	
	public AdressBook(ArrayList<Contact> contacts, String userName) {
		this(contacts);
		this.userName = userName;
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
//	public ArrayList<VisualContact> searchContactsPrevious(String lastName, String firstName, String location, String phonenumber) {
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



	//Alternative search function (by Andreas Albihn)
	//TODO: If final, refactor name
    public ArrayList<VisualContact> optSearchContacts(String lastName, String firstName, String location, String phoneNumber){

        String[] searchValues = new String[4];
        searchValues[0] = lastName;
        searchValues[1] = firstName;
        searchValues[2] = location;
        searchValues[3] = phoneNumber;

        //Create resultlist through recursive method (see below)
        ArrayList<Contact> searchResult = iterateSearchResults(contacts, searchValues, 0);

        ArrayList<VisualContact> convertedResultList = new ArrayList<>();

        for (Contact c : searchResult) {
            convertedResultList.add(new VisualContact(c));
        }

        return convertedResultList;

    }

    //Recursive method to go through each search-value and minimize results for each recursion. (by Andreas Albihn)
    private ArrayList<Contact> iterateSearchResults(ArrayList<Contact> contactList, String[] searchValues, int index){

        String searchValue = searchValues[index].toLowerCase();

        //If search value is empty, skip comparison
        if(!searchValue.equals("")){

            ArrayList<Contact> results = new ArrayList<>();

            for (Contact c : contactList) {

            	int limit = searchValue.length();
            	if(limit>c.getContactValueByIndex(index).length())
            		limit = c.getContactValueByIndex(index).length();

                String compValue = c.getContactValueByIndex(index).toLowerCase().substring(0, limit);


                if(compValue.equals(searchValue))
                    results.add(c);

            }

            index++;

            if(index>3)
                return results;

            return iterateSearchResults(results, searchValues, index);

        }

        //If current search-value was skipped..
        index++;

        if(index>3)
            return contactList;

        return iterateSearchResults(contactList, searchValues, index);

    }

	
	//checks if an Contact is in the contacts arraylist by comparing all Contact in contacts hashcode.
    //will return the contact that match the hashcode.
    //returns null if no contact match
	public Contact selectContact(Contact selectedContact) {
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