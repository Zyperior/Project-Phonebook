package phonebook.gui;


import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import phonebook.base.AdressBook;
import phonebook.base.Contact;
import phonebook.base.VisualContact;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest extends ApplicationTest {

    private Controller controller;

    private VisualContact testVisualContact = new VisualContact(new Contact(
            "Lastname", "Firstname", "Location", "123456789"));

    private Contact testContact = new Contact(
            "ABCDEFGH", "ABCDEFGH", "ABCDEFGH", "12345678");

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GUI.fxml"));
        Parent root = loader.load();

        controller = loader.getController();

    }

    @BeforeEach
    void setUp(){
        controller.init();
    }

    @Test
    void verifyTableInitializationParameters(){
        assertEquals(controller.tableLastNameColumn.getCellData(testVisualContact),"Lastname");
        assertEquals(controller.tableFirstNameColumn.getCellData(testVisualContact),"Firstname");
        assertEquals(controller.tableLocationColumn.getCellData(testVisualContact), "Location");
        assertEquals(controller.tablePhoneColumn.getCellData(testVisualContact), "123456789");
    }

    @Test
    void verifyComboBoxInitializationParameters(){
        assertNotNull(controller.categoryComboBox.getItems());
        assertEquals(controller.categoryComboBox.getSelectionModel().getSelectedIndex(), 0);
    }

    @Test
    void verifyRemoveContactButtonInitializationParameters(){
        assertTrue(controller.removeContactButton.isDisabled());
        controller.contactTable.getSelectionModel().select(0);
        assertFalse(controller.removeContactButton.isDisabled());
    }

    @Test
    void verifyUpdateTableWithNoParameters(){
        int tableSize = controller.contactTable.getItems().size();
        controller.updateTable();
        assertEquals(controller.contactTable.getItems().size(),tableSize);
    }

    @Test
    void verifyUpdateTableWithParameters(){
        ArrayList<VisualContact> tempList = new ArrayList<>();
        tempList.add(testVisualContact);
        controller.contactTable.setItems(FXCollections.observableList(tempList));
        int tableSize = controller.contactTable.getItems().size();
        controller.updateTable("0000000000000000000000000000", "","","");
        assertTrue(controller.contactTable.getItems().size() < tableSize);
    }

    @Test
    void verifyAddButtonDisableProperty(){
        assertTrue(controller.addContactButton.isDisabled());

        controller.adressBook = new AdressBook("TestCategoryToBeDeleted");
        controller.adressBook.getContacts().add(testContact);
        controller.lNameTextField.setText("AAAAAAAAAAAA");
        controller.fNameTextField.setText("BBBBBBBBBBBB");
        controller.locationTextField.setText("CCCCCCCCCCC");
        controller.phoneTextField.setText("9999999999999");

        assertFalse(controller.addContactButton.isDisabled());

        controller.lNameTextField.setText(testContact.getLastName());
        controller.fNameTextField.setText(testContact.getFirstName());
        controller.locationTextField.setText(testContact.getLocation());
        controller.phoneTextField.setText(testContact.getPhoneNumber());

        assertTrue(controller.addContactButton.isDisabled());
    }

    @Test
    void testAddAndRemoveContactFunctionality(){
        controller.adressBook = new AdressBook("TestCategoryToBeDeleted");
        assertEquals(controller.adressBook.getContacts().size(),0);

        controller.lNameTextField.setText(testContact.getLastName());
        controller.fNameTextField.setText(testContact.getFirstName());
        controller.locationTextField.setText(testContact.getLocation());
        controller.phoneTextField.setText(testContact.getPhoneNumber());
        controller.addContactClick();
        assertEquals(controller.adressBook.getContacts().size(),1);

        controller.contactTable.getSelectionModel().select(0);
        controller.removeContactClick();
        assertEquals(controller.adressBook.getContacts().size(),0);

    }

    @Test
    void testChangingAdressBookCategory(){
        String categoryAfterInit = controller.adressBook.getUserName();
        controller.categoryComboBox.getSelectionModel().select(1);
        assertNotEquals(controller.adressBook.getUserName(),categoryAfterInit);
    }


}