package test.java.phonebook.storage;
import org.junit.jupiter.api.Test;
import phonebook.base.Contact;
import phonebook.storage.StoreHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreHandlerTest {

    // Tests that correct file gets generated
    @Test
    void testSaveData() throws IOException {
        StoreHandler handler = new StoreHandler();
        handler.saveData(new ArrayList<Contact>(), "test");
        File testFile = new File("test.txt");
        assertTrue(testFile.exists());
    }
}
