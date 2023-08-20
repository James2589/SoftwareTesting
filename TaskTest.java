package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {

	//Tests Task constructor
	@Test
	void testTask() {
		Task task = new Task("123", "test Task", "build the test to test the task constructor");
		
		assertTrue(task.getID().equals("123"));
		assertTrue(task.getName().equals("test Task"));
		assertTrue(task.getDesc().equals("build the test to test the task constructor"));
		
		
	}
	
	//Tests that length exception is thrown
	@Test
	void testTaskLenghtException() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task("1234567890123", "IDTest","Testing the length of the ID");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task("12345", "NameLengthTesting123456789","Testing the length of the Name");});
		assertTrue(thrown2.getMessage().contains("Invalid Name"));
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task("123456", "DescriptionTest","Testing the length of the Description and that it is less than fifty characters long");});
		assertTrue(thrown3.getMessage().contains("Invalid Description"));
	}
	
	//Test null exception is thrown
	@Test
	void testTaskNullException() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task(null, "testIDNull", "testing the null ID exception");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task("123", null, "testing the null name exception");});
		assertTrue(thrown2.getMessage().contains("Invalid Name"));
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task("1234", "testDescNull", null);});
		assertTrue(thrown3.getMessage().contains("Invalid Description"));
		
	}

}
