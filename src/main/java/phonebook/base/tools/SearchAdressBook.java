/* Date: 2018-12-10
 * Author: Andreas Albihn
 */

package phonebook.base.tools;
import phonebook.base.Contact;
import phonebook.base.VisualContact;

import java.util.ArrayList;

/**
 * Main class to search through contacts in current adressbook and get results based on values.
 */
public class SearchAdressBook {

    /**
     * Standard parameters for the current version of the program.
     * If amount of values in GUI table changes, this might need to be adjusted.
     */
    private static int limit_search_index = 0;
    private static final int START_SEARCH_INDEX = 0;
    private static final String EMPTY_SEARCH_VALUE = "";

    /**
     * Static search method, calls a static recursive method with standard parameters.
     * @param contacts List of contacts to compare with
     * @param lastName Search value, if null set to ""
     * @param firstName Search value, if null set  to ""
     * @param location Search value, if null set to ""
     * @param phoneNumber Search value, if null set to ""
     */
    public static ArrayList<VisualContact> searchContacts(ArrayList<Contact> contacts, String lastName, String firstName, String location, String phoneNumber){

        //Throw exception if list is null.
        if(contacts==null){
            throw new IllegalArgumentException("ArrayList can not be null");
        }


        /**
         * Search values are added to array.
         * NOTE: The size of this array determines the limit_search_index to avoid nullpointerexception.
         * Adjust accordingly to fit current settings in program.
         */
        String[] searchValues = new String[4];
        searchValues[0] = lastName;
        searchValues[1] = firstName;
        searchValues[2] = location;
        searchValues[3] = phoneNumber;

        //Control each value and if null, change to ""
        for (int i = 0; i<searchValues.length; i++){
            if(searchValues[i] == null){
                searchValues[i] = "";
            }
        }

        limit_search_index = searchValues.length;

        //Create resultlist through recursive method (see below)
        ArrayList<Contact> searchResult = iterateSearchResults(contacts, searchValues, START_SEARCH_INDEX);

        ArrayList<VisualContact> convertedResultList = new ArrayList<>();

        /*Convert the results to VisualContact objects.
        If contact is null exception is thrown but as of current project status it is not used.
        */
        for (Contact c : searchResult) {

            VisualContact visualContact;
            try{
                visualContact = new VisualContact(c);
            }
            catch (IllegalArgumentException e){

            }

            convertedResultList.add(new VisualContact(c));
        }

        return convertedResultList;

    }


    /**
     * Recursive method to go through each search-value and minimize results for each recursion.
     * @param contactList List of contacts to search through.
     * @param searchValues List of search values to compare with.
     * @param index set to 0 at first. This param sets the current search value and compare value. Increases by 1 each recursioun.
     *              Cannot exceed internal final int LIMIT_SEARCH_INDEX.
     * @return
     */
    static ArrayList<Contact> iterateSearchResults(ArrayList<Contact> contactList, String[] searchValues, int index){
        if(index >= limit_search_index){
            throw new RuntimeException("Index can not be greater or equals the limit set by the string array");
        }

        //Set current searchValue by current index value
        String searchValue = searchValues[index].toLowerCase();

        //If current searchValue is empty, skip comparison else continue
        if(!searchValue.equals(EMPTY_SEARCH_VALUE)){

            //If current searchValue is not empty, we will get results. Create the list
            ArrayList<Contact> results = new ArrayList<>();

            //Loop through current contactlist
            for (Contact c : contactList) {

                //Set limit to compare with in each contact value,
                //minimum the length of searchValue,
                //maximum the length of value in contact.
                int limit = searchValue.length();
                if(limit>c.getContactValueByIndex(index).length())
                    limit = c.getContactValueByIndex(index).length();

                //Set current compareValue with above limit
                String compValue = c.getContactValueByIndex(index).toLowerCase().substring(0, limit);

                //If match, add contact to result list.
                if(compValue.equals(searchValue))
                    results.add(c);

            }

            //Increase index by 1
            index++;

            //If index has reached the current amount possible values to look up, return the result list to caller.
            if(index==limit_search_index){
                return results;
            }

            //If index not reached limit, call this method again with new result list, same search values and new index value
            return iterateSearchResults(results, searchValues, index);

        }

        //If current search-value was skipped..
        //Increase index by 1
        index++;

        //If index has reached the current amount possible values to look up, return the current list to caller.
        if(index==limit_search_index)
            return contactList;

        //If index not reached limit, call this method again with current list, same search values and new index value
        return iterateSearchResults(contactList, searchValues, index);

    }
}
