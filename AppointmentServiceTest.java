package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Appointment.AppointmentService;


class AppointmentServiceTest {
    //Testing that addAppointment throws length exception
	@Test
	void testAddAppLength() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {AppointmentService.addAppointment("123456789789456", LocalDate.now(), "test that checks that addAppointment throws exception for invalid ID lenght");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {AppointmentService.addAppointment("123", LocalDate.now(), "test that checks that addAppointment throws exception for invalid Description lenght"
				+ "for any descripiton over fifty characters");});
		assertTrue(thrown2.getMessage().contains("Invalid Desc"));
	}
	
	//Testing that addAppointment throws exception for null parameters
	@Test
	void testAddAppNull() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {AppointmentService.addAppointment(null, LocalDate.now(), "test that checks that addAppointment throws exception for null ID");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {AppointmentService.addAppointment("123", null, "test that checks that addAppointment throws exception for null date");});
		assertTrue(thrown2.getMessage().contains("Invalid Date"));
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {AppointmentService.addAppointment("1234", LocalDate.now(), null);});
		assertTrue(thrown3.getMessage().contains("Invalid Description"));
	}
	//Testing that addAppointment throws exception for past date
	@Test
	void testAddAppPastDate(){	
		LocalDate today = LocalDate.now();
    	LocalDate yesterday = today.minus(Period.ofDays(1));
    	
    	IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {AppointmentService.addAppointment("123", yesterday, "test that checks that addAppointment throws exception for past date");});
		assertTrue(thrown1.getMessage().contains("Invalid Date"));
    	
    	
	}
	//Testing that deleteAppointment works correctly;
	@Test
	void testDeleteApp() {
		AppointmentService.addAppointment("123", LocalDate.now(), "Testing deleteTask");
		AppointmentService.addAppointment("1234", LocalDate.now(), "Testing deleteTask");
		AppointmentService.addAppointment("12345", LocalDate.now(), "Testing deleteTask");
		
		assertTrue(AppointmentService.appList.size() == 3);
		AppointmentService.deleteApp("123");
		assertFalse(AppointmentService.appList.size() == 3);
	}

}
