package phonebook.base;

import javafx.beans.property.SimpleStringProperty;

public class VisualContact {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty location;
    private SimpleStringProperty cellPhoneNumber;

    /**
     *
     * Copyconstructor for creating a visual copy of contact-object
     */
    public VisualContact(Contact c){
        this.firstName = new SimpleStringProperty(c.getFirstName());
        this.lastName = new SimpleStringProperty(c.getLastName());
        this.location = new SimpleStringProperty(c.getLocation());
        this.cellPhoneNumber = new SimpleStringProperty(c.getCellPhoneNumber());
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getLocation() {
        return location.get();
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber.get();
    }

}
