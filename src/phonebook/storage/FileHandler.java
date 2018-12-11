package phonebook.storage;
import phonebook.base.Contact;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {


    // Reads input from file and returns an arraylist. Returns an empty list if file does not exist.
    public static ArrayList<Contact> retrieveListFromFile(String category){
        ArrayList<Contact> contacts = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(category + ".txt"))){
            contacts = (ArrayList<Contact>) in.readObject();
        } catch (EOFException e){
            System.out.println("No file exists. New file created");
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
    public static void saveData(ArrayList<Contact> list, String category){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(category + ".txt"))){
            out.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
