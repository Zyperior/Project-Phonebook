/*
Date yy-mm-dd: 18-12-05
Author: Andreas Albihn
 */
package phonebook.gui;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.When;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import phonebook.base.AdressBook;
import phonebook.base.Contact;
import phonebook.base.ContactFactory;
import phonebook.base.VisualContact;
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

    private AdressBook adressBook;

    private List<VisualContact> tempList;

    private ObservableList<VisualContact> observableTempList;

    private BooleanProperty validContact;

    public Controller(){
        adressBook = new AdressBook();
        validContact = new SimpleBooleanProperty();
    }

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
    updates tables with list objects returned from adressbook search function.
    If list is empty and all textfields contains any text set addContactButton enabled.
     */
    private void updateTable(String lastName, String firstName, String location, String phoneNumber){
        tempList = adressBook.search(lastName, firstName, location, phoneNumber);

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

        observableTempList = FXCollections.observableList(tempList);
        contactTable.setItems(observableTempList);
    }


    @FXML
    private void addContactClick(ActionEvent actionEvent){
        String lastName = lNameTextField.getText();
        String firstName = fNameTextField.getText();
        String location = locationTextField.getText();
        String phoneNumber = phoneTextField.getText();

        adressBook.addContact(ContactFactory.createContact(firstName,lastName,location,phoneNumber));

        lNameTextField.setText("");
        fNameTextField.setText("");
        locationTextField.setText("");
        phoneTextField.setText("");
    }

}
