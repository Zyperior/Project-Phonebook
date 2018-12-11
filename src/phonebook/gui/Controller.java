/*
Date yy-mm-dd: 18-12-05
Author: Andreas Albihn
 */
package phonebook.gui;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import phonebook.base.AdressBook;
import phonebook.base.Contact;
import phonebook.base.ContactFactory;
import phonebook.base.VisualContact;
import phonebook.storage.FileHandler;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    @FXML
    TableView<VisualContact> contactTable;
    @FXML
    TableColumn<VisualContact, String> tableLastNameColumn;
    @FXML
    TableColumn<VisualContact, String> tableFirstNameColumn;
    @FXML
    TableColumn<VisualContact, String> tableLocationColumn;
    @FXML
    TableColumn<VisualContact, String> tablePhoneColumn;
    @FXML
    TextField lNameTextField;
    @FXML
    TextField fNameTextField;
    @FXML
    TextField locationTextField;
    @FXML
    TextField phoneTextField;
    @FXML
    Button addContactButton;
    @FXML
    Button removeContactButton;
    @FXML
    ComboBox<String> categoryComboBox;

    private AdressBook adressBook = new AdressBook();

    private List<String> categoryList = new ArrayList<>();

    private Stage stage;

    public Controller(){
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void init(){
        //Contact table settings:
        //--------------------------------------------------------
        tableLastNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));

        tableFirstNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));

        tableLocationColumn.setCellValueFactory(
                new PropertyValueFactory<>("location"));

        tablePhoneColumn.setCellValueFactory(
                new PropertyValueFactory<>("cellPhoneNumber"));
        //--------------------------------------------------------

        //Textfield settings:
        //--------------------------------------------------------
        lNameTextField.textProperty().addListener((observable, oldValue, newValue) ->
                updateTable(newValue,
                        fNameTextField.getText(),
                        locationTextField.getText(),
                        phoneTextField.getText()));

        fNameTextField.textProperty().addListener((observable, oldValue, newValue) ->
                updateTable(lNameTextField.getText(),
                        newValue,
                        locationTextField.getText(),
                        phoneTextField.getText()));

        locationTextField.textProperty().addListener((observable, oldValue, newValue) ->
                updateTable(lNameTextField.getText(),
                        fNameTextField.getText(),
                        newValue,
                        phoneTextField.getText()));

        phoneTextField.textProperty().addListener((observable, oldValue, newValue) ->
                updateTable(lNameTextField.getText(),
                        fNameTextField.getText(),
                        locationTextField.getText(),
                        newValue));
        //--------------------------------------------------------


        //Category combobox settings:
        //--------------------------------------------------------
        categoryList.add("Home");
        categoryList.add("Work");
        categoryList.add("Other");

        categoryComboBox.setItems(FXCollections.observableList(categoryList));

        categoryComboBox.getSelectionModel().selectFirst();

        categoryComboBox.valueProperty().addListener((observable, oldValue, newValue) ->
                loadCategoryAdressBook(newValue));
        //--------------------------------------------------------

        //Button settings:
        //--------------------------------------------------------
        removeContactButton.disableProperty().bind(Bindings.isEmpty(contactTable.getSelectionModel().getSelectedItems()));
        //--------------------------------------------------------

        stage.setResizable(false);

        //Initial update for the table
        loadCategoryAdressBook(categoryComboBox.getValue());
        updateTable();

    }

    /*
    Updates tables with list objects returned from adressbook search function.
    If list is empty and all textfields contains any text set addContactButton enabled.
     */
    private void updateTable(String lastName, String firstName, String location, String phoneNumber){

        List<VisualContact> tempList = adressBook.search(lastName, firstName, location, phoneNumber);
        contactTable.setItems(FXCollections.observableList(tempList));

        List<TextField> textFields = new ArrayList<>();
        textFields.add(lNameTextField);
        textFields.add(fNameTextField);
        textFields.add(locationTextField);
        textFields.add(phoneTextField);

        addContactButton.setDisable(!tempList.isEmpty());

        for (TextField tf : textFields) {
            if(tf.getText().trim().isEmpty()){
                addContactButton.setDisable(true);
                break;
            }
        }

    }

    /*
    Updates table with latest version of current adressbook contact list.
     */
    private void updateTable(){
        updateTable("","","","");
    }

    /*
    Adds contact to current list with current values.
    Resets values to "" if successful.
     */
    @FXML
    private void addContactClick(){
        String lastName = lNameTextField.getText();
        String firstName = fNameTextField.getText();
        String location = locationTextField.getText();
        String phoneNumber = phoneTextField.getText();

        adressBook.addContact(ContactFactory.createContact(firstName,lastName,location,phoneNumber));

        FileHandler.saveData(adressBook.getContacts(), categoryComboBox.getValue());

        lNameTextField.setText("");
        fNameTextField.setText("");
        locationTextField.setText("");
        phoneTextField.setText("");
    }

    @FXML
    private void removeContactClick(){
        VisualContact selectedContact = contactTable.getSelectionModel().getSelectedItem();

        Contact contactToRemove = new Contact(
                selectedContact.getLastName(),
                selectedContact.getFirstName(),
                selectedContact.getLocation(),
                selectedContact.getPhoneNumber());

        adressBook.removeContact(contactToRemove);

        FileHandler.saveData(adressBook.getContacts(), categoryComboBox.getValue());

        updateTable();
    }

    /*
    Fetches specified adressbook by sending category string to adressbook constructor.
     */
    private void loadCategoryAdressBook(String category){
        adressBook = new AdressBook(category);
    }

}