package phonebook.base.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phonebook.base.Contact;
import phonebook.base.VisualContact;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchAdressBookTest {

    private ArrayList<Contact> testList = new ArrayList<>();
    private Contact contact1 = new Contact("Andersson", "Anders", "Svenljunga","023614245");
    private Contact contact2 = new Contact("Karlsson", "Anders", "Bengtsfors","06432111");
    private Contact contact3 = new Contact("Sjogren", "Jenny", "Goteborg","031348484");
    private Contact contact4 = new Contact("Barkhult", "Jorgen", "Svenljunga","023614242");
    private Contact contact5 = new Contact("Svensson", "Jessica", "Stockholm","08844448");

    private ArrayList<VisualContact> resultList;

    @BeforeEach
    void setUp(){
        testList.add(contact1);
        testList.add(contact2);
        testList.add(contact3);
        testList.add(contact4);
        testList.add(contact5);
    }

    @Test
    void testSearchThrowsExceptionIfListIsNull(){
        try{
            SearchAdressBook.searchContacts(null,null,null,null,null);
            fail("Expected exception not thrown");
        }
        catch(IllegalArgumentException e){

        }
    }

    @Test
    void testSearchConvertNullSearchStringsToEmptyString(){
        resultList = SearchAdressBook.searchContacts(testList, null,null,null,null);
        assertEquals(testList.size(),resultList.size());
    }

    @Test
    void testIterationCapacityExceededThrowException(){
        String[] searchValues = new String[4];
        try{
            SearchAdressBook.iterateSearchResults(testList,searchValues,5);
            fail("Expected exception not thrown");
        }
        catch(RuntimeException e){
            
        }
    }

    @Test
    void testVariousSearchCombinations(){

        //Only last name, 1 letter, "s". Should return two results.
        resultList = SearchAdressBook.searchContacts(testList,"s", null, null, null);
        assertEquals(2,resultList.size());

        //Only last name, 2 letters, "sj". Should return 1 result.
        resultList = SearchAdressBook.searchContacts(testList,"sj",null,null,null);
        assertEquals(1,resultList.size());

        //Only first name, 1 letter, "j". Should return 3 result.
        resultList = SearchAdressBook.searchContacts(testList,null,"j",null, null);
        assertEquals(3,resultList.size());

        //Only location, exact match, "svenljunga". Should return 2 results.
        resultList = SearchAdressBook.searchContacts(testList,null,null,"svenljunga",null);
        assertEquals(2,resultList.size());

        //Location exact match and number almost exact. Should return 2 results.
        resultList = SearchAdressBook.searchContacts(testList,null,null,"svenljunga", "02361424");
        assertEquals(2,resultList.size());
        //Same as above but exact match on number. Should return 1 result.
        resultList = SearchAdressBook.searchContacts(testList,null,null,"svenljunga", "023614242");
        assertEquals(1,resultList.size());
        //Same as above but add another random digit to the phone number. Should return 0 results.
        resultList = SearchAdressBook.searchContacts(testList,null,null,"svenljunga", "0236142429");
        assertEquals(0,resultList.size());


    }



}