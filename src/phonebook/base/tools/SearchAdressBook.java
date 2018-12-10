/* Date dd-mm-yyyy: 10-12-2018
 * Author: Andreas Albihn
 */

package phonebook.base.tools;

import phonebook.base.AdressBook;
import phonebook.base.Contact;
import phonebook.base.VisualContact;

import java.util.ArrayList;

public class SearchAdressBook {

    public static ArrayList<VisualContact> searchContacts(ArrayList<Contact> contacts, String lastName, String firstName, String location, String phoneNumber){

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
    private static ArrayList<Contact> iterateSearchResults(ArrayList<Contact> contactList, String[] searchValues, int index){

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
}
