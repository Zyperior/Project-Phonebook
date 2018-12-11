/*
Date yy-mm-dd: 18-12-06
Author: Andreas Albihn
 */

package phonebook.base;

import javafx.beans.property.SimpleStringProperty;

/**
 * Visual class for contacts used in GUI.
 */
public class VisualContact {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty location;
    private SimpleStringProperty phoneNumber;

    /**
     *
     * Copyconstructor for creating a visual copy of contact-object
     */
    public VisualContact(Contact c){
        this.firstName = new SimpleStringProperty(c.getFirstName());
        this.lastName = new SimpleStringProperty(c.getLastName());
        this.location = new SimpleStringProperty(c.getLocation());
        this.phoneNumber = new SimpleStringProperty(c.getPhoneNumber());
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
        return phoneNumber.get();
    }

}