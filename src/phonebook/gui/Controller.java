package phonebook.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import phonebook.base.Contact;


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

    public Controller(){}

    
}
