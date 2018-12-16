package test.java.phonebook.storage;
import org.junit.jupiter.api.Test;
import phonebook.base.Contact;
import phonebook.storage.FileHandler;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class FileHandlerTest {

    // Tests that input and output writes correct data
    @Test
    void testFileHandler(){
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact one = new Contact("Hansen", "Hans", "Göteborg", "12345678");
        contacts.add(one);
        FileHandler.saveData(contacts, "testFileHandler");
        ArrayList<Contact> contacts2 = new ArrayList<>(FileHandler.retrieveListFromFile("testFileHandler"));
        assertEquals("Hansen",contacts2.get(0).getLastName());
        assertEquals("Hans",contacts2.get(0).getFirstName());
        assertEquals("Göteborg",contacts2.get(0).getLocation());
        assertEquals("12345678",contacts2.get(0).getPhoneNumber());
    }
}
