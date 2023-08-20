package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;


import java.time.LocalDate;
import java.time.Period;


class AppointmentTest {
    
	//Test Appointment Constructor
	@Test
	void testAppointment() {
		
		Appointment app = new Appointment("123", LocalDate.now(), "Testing appointment" );
		
		assertTrue(app.getAppID().equals("123"));
		assertTrue(app.getDate().equals(LocalDate.now()));
		assertTrue(app.getDesc().equals("Testing appointment"));
	}
	//Test for Length Exception
    @Test
    void TestAppointmentLenghtException() {
    	IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class,
    			() -> {new Appointment("1234567890123", LocalDate.now(),"Testing the length of the AppointmentID");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class,
    			() -> {new Appointment("1234567", LocalDate.now(),"Testing the length of the AppointmentDesc to ensure that if the length exceeds 50"
    					+ "there will be an exception thrown reading Invalid Description");});
		assertTrue(thrown2.getMessage().contains("Invalid Description"));
    }
    //Test for Null Exception
    @Test
    void TestAppointmentNullException() {
    	IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class,
    			() -> {new Appointment(null, LocalDate.now(),"Testing AppointmentID null");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class,
    			() -> {new Appointment("12345678", null,"Testing Date null");});
		assertTrue(thrown2.getMessage().contains("Invalid Date"));
		
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class,
    			() -> {new Appointment("12345678", LocalDate.now(), null);});
		assertTrue(thrown3.getMessage().contains("Invalid Description"));
    }
    //Test for Past Date
    @Test
    void TestAppointmentDate() {
    	LocalDate today = LocalDate.now();
    	LocalDate yesterday = today.minus(Period.ofDays(1));
    	
    	IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class,
    			() -> {new Appointment("1234567", yesterday,"Testing for past date exception");});
		assertTrue(thrown1.getMessage().contains("Invalid Date"));
    }
   
}
