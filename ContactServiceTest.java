package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contact.ContactService;


class ContactServiceTest {

	@Test
	void testAddContactLength() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("123456789789456", "John", "Smith", "1112223333", "1234 Main ST");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("1234", "Johnsmithhgf", "Smith", "1112223333", "1234 Main ST");});
		assertTrue(thrown2.getMessage().contains("Invalid First Name"));
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("12345", "John", "Smithkjhbbjhjhggjhj", "1112223333", "1234 Main ST");});
		assertTrue(thrown3.getMessage().contains("Invalid Last Name"));
		IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("123456", "John", "Smith", "1112233232523333", "1234 Main ST");});
		assertTrue(thrown4.getMessage().contains("Invalid Phone Number"));
		IllegalArgumentException thrown5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("1234567", "John", "Smith", "11122233", "1234 Main ST");});
		assertTrue(thrown5.getMessage().contains("Invalid Phone Number"));
		IllegalArgumentException thrown6 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("12345678", "John", "Smith", "1112223333", "1234 Main ST alsdkjfaklsdhfak anksdjfka a;sdklfjakls;sdh alksdjfklasjdf a;ksldhfakl;sdjf askdjfklasdjf");});
		assertTrue(thrown6.getMessage().contains("Invalid Address"));
	}
	
	@Test
	void testAddContactNull() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact(null, "John", "Smith", "1112223333", "1234 Main ST");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("12345", null, "Smith", "1112223333", "1234 Main ST");});
		assertTrue(thrown2.getMessage().contains("Invalid First Name"));
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("1234567", "John", null, "1112223333", "1234 Main ST");});
		assertTrue(thrown3.getMessage().contains("Invalid Last Name"));
		IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("12345678", "John", "Smith", null, "1234 Main ST");});
		assertTrue(thrown4.getMessage().contains("Invalid Phone Number"));
		IllegalArgumentException thrown5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {ContactService.addContact("123456789", "John", "Smith", "1112223333", null);});
		assertTrue(thrown5.getMessage().contains("Invalid Address"));
		
	}
	
	@Test
	void testDeleteContact() {
		ContactService.addContact("1234", "John", "Smith", "1112223333", "1234 Main ST");
		ContactService.addContact("1235", "Jason", "doe", "1112423333", "1235 Main ST");
		ContactService.addContact("1256", "James", "Jones", "1112223533", "1236 Main ST");
		
		assertTrue(ContactService.contactList.size() == 3);
		ContactService.deleteContact("1234");
		assertFalse(ContactService.contactList.size() == 3);
	}
	
	@Test
	void testUpdateFirstName() {
		ContactService.addContact("123477", "John", "Smith", "1112223333", "1234 Main ST");
		ContactService.updateFirstName("123477", "James");
		
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getID() == "123477") {
				assertFalse(ContactService.contactList.get(i).getFirstName() == "John");
			}
			if(ContactService.contactList.get(i).getID() == "123477") {
				assertTrue(ContactService.contactList.get(i).getFirstName() == "James");
			}
		}
		ContactService.deleteContact("123477");
	}
	
	@Test
	void testUpdateLastName() {
		ContactService.addContact("123476", "John", "Smith", "1112223333", "1234 Main ST");
		ContactService.updateLastName("123476", "Jones");
		
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getID() == "123476") {
				assertFalse(ContactService.contactList.get(i).getLastName() == "Smith");
			}
			if(ContactService.contactList.get(i).getID() == "123476") {
				assertTrue(ContactService.contactList.get(i).getLastName() == "Jones");
			}
		}
		ContactService.deleteContact("123476");
	}
	
	@Test
	void testUpdatePhoneNum() {
		ContactService.addContact("123475", "John", "Smith", "1112223333", "1234 Main ST");
		ContactService.updatePhoneNumber("123475", "2223334444");
		
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getID() == "123475") {
				assertFalse(ContactService.contactList.get(i).getPhoneNum() == "1112223333");
			}
			if(ContactService.contactList.get(i).getID() == "123475") {
				assertTrue(ContactService.contactList.get(i).getPhoneNum() == "2223334444");
			}
		}
		ContactService.deleteContact("123475");
	}
	
	@Test
	void testUpdateAddress() {
		ContactService.addContact("123471", "John", "Smith", "1112223333", "1234 Main ST");
		ContactService.updateAddress("123471", "7895 Broad AVE");
		
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getID() == "123471") {
				assertFalse(ContactService.contactList.get(i).getAddress() == "1234 Main ST");
			}
			if(ContactService.contactList.get(i).getID() == "123471") {
				assertTrue(ContactService.contactList.get(i).getAddress() == "7895 Broad AVE");
			}
		}
		ContactService.deleteContact("123471");
	}

}
