package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contact.Contact;


class ContactTest {

	@Test
	void contactTest() {
		Contact contact = new Contact("1234", "john", "Smith", "1112223333", "12345 Main ST");
		
		assertTrue(contact.getID().equals("1234"));
		assertTrue(contact.getFirstName().equals("john"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getPhoneNum().equals("1112223333"));
		assertTrue(contact.getAddress().equals("12345 Main ST"));
		
		}
	@Test
	void TestContactLength() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("123456489756425465", "Steve","Smith", "1234567892", "1212 Main St");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("1234", "Steveknjjnjb","Smith", "1234567892", "12123 Main St");});
		assertTrue(thrown2.getMessage().contains("Invalid First Name"));
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("12345", "Mark","Smithjkbljhgjhvg", "1234577892", "12124 Main St");});
		assertTrue(thrown3.getMessage().contains("Invalid Last Name"));
		IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("12346", "Dave","Jacobs", "123456789265465", "12125 Main St");});
		assertTrue(thrown4.getMessage().contains("Invalid Phone Number"));
		IllegalArgumentException thrown5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("12347", "Marie","Smith", "1234567992", "121212312156454857965467623 Main Street, ajkdnkajf Mississippi");});
		assertTrue(thrown5.getMessage().contains("Invalid Address"));	
	}
	
	@Test
	void TestContactNull() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(null, "Steve","Smith", "1234567892", "1212 Main St");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("123", null,"Smith", "1234567897", "12123 Main St");});
		assertTrue(thrown2.getMessage().contains("Invalid First Name"));
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("1234", "Mark",null, "1234567894", "12124 Main St");});
		assertTrue(thrown3.getMessage().contains("Invalid Last Name"));
		IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("1235", "James","Smith", null, "12125 Main St");});
		assertTrue(thrown4.getMessage().contains("Invalid Phone Number"));
		IllegalArgumentException thrown5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("1236", "Rose","Smith", "1234567893", null);});
		assertTrue(thrown5.getMessage().contains("Invalid Address"));
	}


}
