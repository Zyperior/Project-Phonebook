/*
Robin Säfström ITHS 2018
 */
package phonebook.base;


public class ContactFactory {


    public static Contact createContact(String firstName, String lastName, String location, String cellPhoneNumber) {

   

        return new Contact(firstName,lastName,location,cellPhoneNumber);
    }

}
