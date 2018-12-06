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
	public ArrayList<VisualContact> searchContacts(String lastName, String firstName, String location, String phonenumber) {
		
		ArrayList<String> searchTerms = new ArrayList<>();

		if (lastName.length() > 0 && lastName != null) 
			searchTerms.add(lastName);
		if (firstName.length() > 0 && firstName != null) 
			searchTerms.add(firstName);
		if (location.length() > 0 && location != null) 
			searchTerms.add(location);
		if (phonenumber.length() > 0 && phonenumber != null) 
			searchTerms.add(phonenumber);
		
		ArrayList<VisualContact> searchResult = new ArrayList<>();
		
		for (Contact c : this.contacts) {
			int matches = 0;
			
			for (String s : searchTerms) {
				System.out.println(searchTerms.size());
				s=s.toLowerCase();
				if (c.toString().toLowerCase().contains(s)) {
					System.out.println(s + " exists");
					matches++;
					}
					System.out.println("Matches: " + matches);
				if (matches == searchTerms.size()) {
					searchResult.add(new VisualContact(c));
				}
			}
		}
		return searchResult;
	}

	//optional search function (by Andreas Albihn)
    public ArrayList<VisualContact> optSearchContacts(String lastName, String firstName, String location, String phonenumber){

	    //Create array of Strings and add searchStrings
        String[] searchTerms = new String[4];
        searchTerms[0] = lastName;
        searchTerms[1] = firstName;
        searchTerms[2] = location;
        searchTerms[3] = phonenumber;

        //Create resultlist through recursive method (see below)
        ArrayList<Contact> searchResult = iterateSearchResults(contacts, searchTerms, 0);

        //Create list with visualContacts to convert searchresult to.
        ArrayList<VisualContact> convertedResultList = new ArrayList<>();

        //Convert the results
        for (Contact c : searchResult) {
            convertedResultList.add(new VisualContact(c));
        }

        return convertedResultList;

    }

    //Recursive method to go through each searchterm and minimize results for each recursion.
    private ArrayList<Contact> iterateSearchResults(ArrayList<Contact> contactList, String[] searchValues, int index){

	    //Set current search value
        String searchValue = searchValues[index].toLowerCase();

        //If search value is empty, skip comparison
        if(!searchValue.equals("")){

            //Create resultlist for current comparison
            ArrayList<Contact> results = new ArrayList<>();

            //Iterate through current list and add matching results to list
            for (Contact c : contactList) {
                String compValue = c.getContactValueByIndex(index).toLowerCase().substring(0, searchValue.length());

                if(compValue.equals(searchValue))
                    results.add(c);

            }

            //Go to next search-value and compare-value on the list
            index++;

            //If index is 4 all search values and compare values have been compared, return the results
            if(index>3)
                return results;

            //Else iterate through new result-list on the next index value
            return iterateSearchResults(results, searchValues, index);

        }

        //If current search-value was skipped..
        //Go to next search-value and compare-value on the list
        index++;

        //If index is 4 all search values and compare values have been compared, return the results
        if(index>3)
            return contactList;

        //Iterate through the current list again, with next value for comparison.
        return iterateSearchResults(contactList, searchValues, index);


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