/*
Date yy-mm-dd: 18-12-05
Author: Andreas Albihn
 */
package phonebook.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import phonebook.base.AdressBook;
import phonebook.base.Contact;
import phonebook.base.VisualContact;

import java.util.List;


public class Controller {

    @FXML
    TableView<Contact> contactTable;
    @FXML
    TableColumn<Contact, String> tableLastNameColumn;
    @FXML
    TableColumn<Contact, String> tableFirstNameColumn;
    @FXML
    TableColumn<Contact, String> tableLocationColumn;
    @FXML
    TableColumn<Contact, String> tablePhoneColumn;
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

    AdressBook adressBook = new AdressBook();

    List<VisualContact> tempList;

    public Controller(){}

    public void init(){
        lNameTextField.textProperty().addListener((observable, oldValue, newValue) -> updateTable());
    }

    /*
    under construction
    updates tables with list objects returned from adressbook search function.
     */
    private void updateTable(){
        //tempList = adressBook.searchContacts();
        ObservableList<Contact> observableTempList = FXCollections.observableList(tempList);
        for (Contact c : observableTempList) {



        }
    }




}
