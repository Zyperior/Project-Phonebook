package phonebook.base;

import java.util.List;

public interface Searchable {

    List<Contact> search(String lastName, String firstName, String location, String phoneNumber);
}
