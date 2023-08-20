package Contact;

public class Contact {
	
	// Contact variables
	private String contactID;
	public String firstName;
	public String lastName;
	public String phoneNum;
	public String address;
	
	public Contact(){};
	//Verifying variables meet requirements
	public Contact(String ID, String fName, String lName, String phone, String addr) {
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if(lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if(addr == null || addr.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		//assigning contact information
		this.contactID = ID;
		this.firstName = fName;
		this.lastName = lName;
		this.phoneNum = phone;
		this.address = addr;
	}
	
	//getters for contact information
	public String getID(){
		return contactID;
	}	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getAddress(){
		return address;
	}
}
	