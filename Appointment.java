package Appointment;

import java.time.LocalDate;

public class Appointment {
   //initialize variables
	private String appID;
	private LocalDate appDate;
	public String appDesc;
	
	public Appointment(String ID, LocalDate date, String Desc) {
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(date == null || date.isBefore(LocalDate.now())){
			throw new IllegalArgumentException("Invalid Date");
		}
		if(Desc == null || Desc.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.appID = ID;
		this.appDate = date;
		this.appDesc = Desc;
	}
	
	//Getters for App ID, Date, and Description.
	public String getAppID() {
		return appID;
	}
	
	public LocalDate getDate() {
		return appDate;
	}
	
	public String getDesc() {
		return appDesc;
	}
}
