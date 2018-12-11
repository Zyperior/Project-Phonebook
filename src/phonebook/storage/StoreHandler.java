package phonebook.storage;

import phonebook.base.Contact;

import java.io.*;
import java.util.ArrayList;

public class StoreHandler {

    FileHandler fileHandler = new FileHandler();

    public void saveData(ArrayList<Contact> list, String category) {
        File file = new File(category + ".txt");
        try {
            file.createNewFile(); // Creates new file if it does not exist already
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileHandler.saveData(list, category);



    }

    public ArrayList<Contact> loadData(String category)  {
        File file = new File(category + ".txt");

        try {
            file.createNewFile();
        }  catch (IOException e) {
            e.printStackTrace();
        }

        return fileHandler.retrieveListFromFile(category);

    }

}


