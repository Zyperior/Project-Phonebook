/*
Robin Säfström ITHS 2018
 */
package phonebook.base;


public class ContactFactory {


    public static Contact createContact(String lastName, String firstName, String location, String cellPhoneNumber) {

   

        return new Contact(lastName,firstName,location,cellPhoneNumber);
    }

}
