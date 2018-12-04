package phonebook.storage;
import phonebook.base.*;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {


    // Reads input from file and returns an arraylist
    public ArrayList<Contact> retrieveListFromFile(){
        ArrayList<Contact> contacts = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("AdressBook.txt"))){
            contacts = (ArrayList<Contact>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    // Writes Arraylist to file
    public void saveData(ArrayList<Contact> list){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("AdressBook.txt"))){
            out.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
