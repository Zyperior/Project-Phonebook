package phonebook.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdressBookFactoryTest {

	AdressBookFactory classUnderTest;
	
	//test fail if the returned adressbook is equal to null or if the field is equal to null 
	@Test
	void nullTest() {
		String category = "test";
		AdressBook returnedAdressBook = AdressBookFactory.createAdressBook(category);  
		assertTrue(returnedAdressBook != null && returnedAdressBook.category != null);
	}

	//Makes sure that the returned object is of class AdressBook
	@Test
	void typeTest( ) {
		String category = "test";
		AdressBook returnedAdressBook = AdressBookFactory.createAdressBook(category);  
		assertEquals(AdressBook.class, returnedAdressBook.getClass());
	}
	
}
