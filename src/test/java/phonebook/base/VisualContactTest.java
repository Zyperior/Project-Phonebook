package phonebook.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class VisualContactTest {

    Contact contact = new Contact("abcdef", "abcdef", "abcdef", "1234567");
    VisualContact visualContact;

    /*
    Test that the contructor throws exception if parameter is null
     */
    @Test
    void testVisualContactConstructorNullParameter(){
        try{
            visualContact = new VisualContact(null);
            fail("No exception thrown if parameter is null");
        }
        catch (IllegalArgumentException e){

        }
    }

    /*
    Test that the Contact object is properly copied to the VisualContact object.
     */
    @Test
    void testVisualContactConstructor(){
        try{
            visualContact = new VisualContact(contact);
        }
        catch (IllegalArgumentException e){
            fail("Exception thrown even if parameter is valid");
        }

        assertEquals(visualContact.getLastName(),contact.getLastName());
        assertEquals(visualContact.getFirstName(),contact.getFirstName());
        assertEquals(visualContact.getLocation(),contact.getLocation());
        assertEquals(visualContact.getPhoneNumber(), contact.getPhoneNumber());
    }

}