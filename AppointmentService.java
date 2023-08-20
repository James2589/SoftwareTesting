package Appointment;

import java.util.ArrayList;
import java.time.LocalDate;

public class AppointmentService {
   public static ArrayList<Appointment> appList = new ArrayList<Appointment>();
   
   public static void addAppointment(String ID, LocalDate date, String Desc) {
	   Appointment newApp = new Appointment(ID, date, Desc);
	   
	   for(int i = 0; i < appList.size(); i++) {
		   if(ID.equals(appList.get(i).getAppID())){
			   throw new IllegalArgumentException("ID already exist");
		   }
	   }
	   appList.add(newApp);
	   
   }
   
   public static void deleteApp(String ID) {
	   for(int i = 0; i < appList.size(); i++) {
		   if(ID.equals(appList.get(i).getAppID())){
			   appList.remove(i);
		   }
	   }
   }
}
