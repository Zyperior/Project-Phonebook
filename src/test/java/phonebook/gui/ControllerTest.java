/*
Date yy-mm-dd: 18-12-15
Author: Andreas Albihn
 */

package phonebook.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import phonebook.base.AdressBook;
import phonebook.base.Contact;
import phonebook.base.VisualContact;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testclass for Controller for main GUI. Most vital functionality is tested.
 * Skipped testing for various listeners.
 */
public class ControllerTest extends ApplicationTest {

    /*
    Class variables to be used in various tests
     */
    private Controller controller;
    private VisualContact testVisualContact = new VisualContact(new Contact(
            "Lastname", "Firstname", "Location", "123456789"));
    private Contact testContact = new Contact(
            "ABCDEFGH", "ABCDEFGH", "ABCDEFGH", "12345678");

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GUI.fxml"));
        loader.load();

        controller = loader.getController();
    }

    /*
    Initializes the controller for each test to begin from a clean slate.
     */
    @BeforeEach
    void setUp(){
        controller.init();
    }

    /*
    Controls that each column in table displays correct information from contact.
     */
    @Test
    void verifyTableInitializationParameters(){
        assertEquals(controller.tableLastNameColumn.getCellData(testVisualContact),"Lastname");
        assertEquals(controller.tableFirstNameColumn.getCellData(testVisualContact),"Firstname");
        assertEquals(controller.tableLocationColumn.getCellData(testVisualContact), "Location");
        assertEquals(controller.tablePhoneColumn.getCellData(testVisualContact), "123456789");
    }

    /*
    Controls that the category-ComboBox is properly set up by the initialization.
     */
    @Test
    void verifyComboBoxInitializationParameters(){
        assertNotNull(controller.categoryComboBox.getItems());
        assertEquals(controller.categoryComboBox.getSelectionModel().getSelectedIndex(), 0);
    }

    /*
    Controls that the Remove-Contact-Button is disabled and enabled when it should be.
     */
    @Test
    void verifyRemoveContactButtonInitializationParameters(){
        //Adds contact to table
        ArrayList<VisualContact> tempList = new ArrayList<>();
        tempList.add(testVisualContact);
        controller.contactTable.setItems(FXCollections.observableList(tempList));
        //No row yet selected, button should be disabled.
        assertTrue(controller.removeContactButton.isDisabled());

        //Select the added contact row.
        controller.contactTable.getSelectionModel().select(0);

        //Row selected, button should be enabled.
        assertFalse(controller.removeContactButton.isDisabled());
    }

    /*
    Controls that updateTable refreshes the list with no parameters.
     */
    @Test
    void verifyUpdateTableWithNoParameters(){
        int tableSize = controller.contactTable.getItems().size();
        controller.updateTable();
        assertEquals(controller.contactTable.getItems().size(),tableSize);
    }

    /*
    Controls that updateTable reloads the table with values based on parameters.
     */
    @Test
    void verifyUpdateTableWithParameters(){
        ArrayList<VisualContact> tempList = new ArrayList<>();
        tempList.add(testVisualContact);
        controller.contactTable.setItems(FXCollections.observableList(tempList));
        int tableSize = controller.contactTable.getItems().size();
        controller.updateTable("0000000000000000000000000000", "","","");
        assertTrue(controller.contactTable.getItems().size() < tableSize);
    }

    /*
    Controls the Add-Contact-Button disable and enabled settings.
     */
    @Test
    void verifyAddButtonDisableProperty(){
        //At start, button should be disabled.
        assertTrue(controller.addContactButton.isDisabled());

        //Loads a temporary adressBook. Adds a contact to the list.
        controller.adressBook = new AdressBook("TestCategoryToBeDeleted");
        controller.adressBook.getContacts().add(testContact);
        //Set textfield values to different from the contact values. Table should show zero result.
        controller.lNameTextField.setText("AAAAAAAAAAAA");
        controller.fNameTextField.setText("BBBBBBBBBBBB");
        controller.locationTextField.setText("CCCCCCCCCCC");
        controller.phoneTextField.setText("9999999999999");

        //Button should now be enabled.
        assertFalse(controller.addContactButton.isDisabled());

        //Set textfields to the same as contact values. Table should show the contact.
        controller.lNameTextField.setText(testContact.getLastName());
        controller.fNameTextField.setText(testContact.getFirstName());
        controller.locationTextField.setText(testContact.getLocation());
        controller.phoneTextField.setText(testContact.getPhoneNumber());

        //Button should be disabled again.
        assertTrue(controller.addContactButton.isDisabled());
    }

    /*
    Tests the addContact functionality.
    Also tests the removeContact on the same instance.
    IMPORTANT! Should this test fail, remove the "TestCategoryToBeDeleted" manually before testing again.
     */
    @Test
    void testAddAndRemoveContactFunctionality(){
        //Sets a temporary test adressBook and controls that its empty.
        controller.adressBook = new AdressBook("TestCategoryToBeDeleted");
        assertEquals(controller.adressBook.getContacts().size(),0);

        //Fills the textFields with acceptable values and adds contact.
        controller.lNameTextField.setText(testContact.getLastName());
        controller.fNameTextField.setText(testContact.getFirstName());
        controller.locationTextField.setText(testContact.getLocation());
        controller.phoneTextField.setText(testContact.getPhoneNumber());
        controller.addContactClick();
        //Contactlist in adressBook should now contain 1 contact.
        assertEquals(controller.adressBook.getContacts().size(),1);

        //Selects the first row in the table where the contact is displayed and removes the contact
        controller.contactTable.getSelectionModel().select(0);
        controller.removeContactClick();
        //Contactlist in adressBook should now be empty again.
        assertEquals(controller.adressBook.getContacts().size(),0);

    }

    //Test that the adressBook changes when another value is selected in the categoryComboBox.
    @Test
    void testChangingAdressBookCategory(){
        //Sets the name of the initial adressBook.
        String categoryAfterInit = controller.adressBook.getUserName();
        //Change value in categoryComboBox
        controller.categoryComboBox.getSelectionModel().select(1);
        //Current adressBook should now be different from the initial adressBook.
        assertNotEquals(controller.adressBook.getUserName(),categoryAfterInit);
    }


}