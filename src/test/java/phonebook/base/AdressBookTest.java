package phonebook.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdressBookTest {

	AdressBook classUnderTest;
	String category = "test";
	
	//test fail if the adressbook is equal to null or if the field is equal to null 
	@Test
	void nullTest() {
		classUnderTest = new AdressBook(category);
		assertTrue(classUnderTest != null && classUnderTest.category != null);
	}
	
	//This test assures that contact is added to the contacts arraylist by 
	//comparing the size of the contacts array before and after adding a contact
	@Test
	void addContactTest(){
		classUnderTest = new AdressBook(category);
		int contactsSizeBeforeAdd = classUnderTest.getContacts().size();
		classUnderTest.addContact(new Contact("eriksson", "lennart", "göteborg", "12345678"));
		assertTrue(classUnderTest.getContacts().size() == contactsSizeBeforeAdd +1);
	}
	
	//This test assures that contact is removed from the contacts arraylist by 
	//comparing the size of the contacts array before and after removing the contact
	@Test
	void removeContactTest(){
		classUnderTest = new AdressBook(category);
		Contact testContact = new Contact("eriksson", "lennart", "göteborg", "12345678");
		classUnderTest.addContact(testContact);
		int contactsSizeBeforeRemove = classUnderTest.getContacts().size();
		classUnderTest.removeContact(testContact);
		assertTrue(classUnderTest.getContacts().size() == contactsSizeBeforeRemove -1);
	}
	
	//since verifyContactObject method is run privately within addContact the test will call upon the addContact method
	@Test
	void verifyContactTest() {
		String lastName = "Eriksson";
		String firstName = "Lennart";
		String location = "Göteborg";
		String number = "12344567";
		classUnderTest = new AdressBook(category);

		//verify Contact
		try {
			classUnderTest.addContact(null);
			fail("Program didn't catch the exception for Contact");
		}catch(Exception e){
			
		}
		//verify lastName test
		try {
			classUnderTest.addContact(new Contact(null, firstName, location, number));
			fail("Program didn't catch the exception for lastName");
		}catch (Exception e) {
			
		}
		//verify firstName test
		try {
			classUnderTest.addContact(new Contact(lastName, null, location, number));
			fail("Program didn't catch the exception for firstName");
		}catch (Exception e) {
			
		}
		
		//verify location test
		try {
			classUnderTest.addContact(new Contact(lastName, firstName, null, number));
			fail("Program didn't catch the exception for location");
		}catch (Exception e) {
			
		}
		//verify number test
		try {
			classUnderTest.addContact(new Contact(lastName, firstName, location, null));
			fail("Program didn't catch the exception for number");
		}catch (Exception e) {
			
		}
	}
	
}
