package Contact;

import java.util.ArrayList;


public class ContactService extends Contact {
   public static ArrayList<Contact> contactList = new ArrayList<Contact>();
   
   
   //Add contact function
   public static void addContact(String ID, String fName, String lName, String phone, String addr) {
	   Contact newContact = new Contact(ID, fName, lName, phone, addr);
	   
	   for(int i = 0; i < contactList.size(); i++) {
		   if(ID.equals(contactList.get(i).getID())){
			   throw new IllegalArgumentException("ID already exist");
		   }
	   }
	   contactList.add(newContact);
   }
   //delete contact method
   public static void deleteContact(String ID) {
	   for(int i = 0; i < contactList.size(); i++) {
		   if(ID.equals(contactList.get(i).getID())){
			   contactList.remove(i);
		   }
	   }
   }

   //update methods
   public static void updateFirstName(String ID, String fName) {
	   if(fName == null || fName.length() > 20) {
			throw new IllegalArgumentException("Invalid First Name");
		}
	   for(int i = 0; i < contactList.size(); i++) {
		   if(ID.equals(contactList.get(i).getID())){
			   contactList.get(i).firstName = fName;
		   }
      }
   }
   
   public static void updateLastName(String ID, String lName) {
	   if(lName == null || lName.length() > 20) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
	   for(int i = 0; i < contactList.size(); i++) {
		   if(ID.equals(contactList.get(i).getID())){
			   contactList.get(i).lastName = lName;
		   }
      }
   }
   
   public static void updatePhoneNumber(String ID, String phone) {
	   if(phone == null || phone.length() > 20) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
	   for(int i = 0; i < contactList.size(); i++) {
		   if(ID.equals(contactList.get(i).getID())){
			   contactList.get(i).phoneNum = phone;
		   }
      }
   }
   
   public static void updateAddress(String ID, String addr) {
	   if(addr == null || addr.length() > 20) {
			throw new IllegalArgumentException("Invalid Address");
		}
	   for(int i = 0; i < contactList.size(); i++) {
		   if(ID.equals(contactList.get(i).getID())){
			   contactList.get(i).address = addr;
		   }
      }
   }
}
