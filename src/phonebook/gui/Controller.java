/*
Date yy-mm-dd: 18-12-05
Author: Andreas Albihn
 */
package phonebook.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import phonebook.base.AdressBook;
import phonebook.base.Contact;
import phonebook.base.VisualContact;

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

    AdressBook adressBook = new AdressBook();

    List<VisualContact> tempList;

    public Controller(){}

    public void init(){

        tableLastNameColumn.setCellValueFactory(
                new PropertyValueFactory<VisualContact,String>("lastName"));

        tableFirstNameColumn.setCellValueFactory(
                new PropertyValueFactory<VisualContact,String>("firstName"));

        tableLocationColumn.setCellValueFactory(
                new PropertyValueFactory<VisualContact,String>("location"));

        tablePhoneColumn.setCellValueFactory(
                new PropertyValueFactory<VisualContact,String>("cellPhoneNumber"));

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

        //Testobjects to be removed before finalization
        adressBook.addContact(new Contact("Bengt", "Bengtsson", "göteborg", "12345678"));
        adressBook.addContact(new Contact("Sven","Bengtsson", "göteborg", "432423234"));
        adressBook.addContact(new Contact("Anna","Andersson", "Karlstad", "88787878"));

        updateTable("","","","");

    }

    /*
    under construction
    updates tables with list objects returned from adressbook search function.
     */
    private void updateTable(String lastName, String firstName, String location, String phoneNumber){
        tempList = adressBook.optSearchContacts(lastName, firstName, location, phoneNumber);
        ObservableList<VisualContact> observableTempList = FXCollections.observableList(tempList);
        contactTable.setItems(observableTempList);
    }




}
