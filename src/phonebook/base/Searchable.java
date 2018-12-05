package phonebook.base;

import java.util.List;

public interface Searchable {

    List<Contact> search(String... searchStrings);
}
