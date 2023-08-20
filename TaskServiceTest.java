package Test;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import Task.TaskService;

class TaskServiceTest {

	//Testing that addTask throws exception for invalid length parameters
	@Test
	void testAddTaskLength() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {TaskService.addTask("123456789789456", "testIDException", "test that checks that addtask throws exception for invalid ID lenght");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {TaskService.addTask("123", "testNameExceptionfortolongofaname", "test that checks that addtask throws exception for invalid name lenght");});
		assertTrue(thrown2.getMessage().contains("Invalid Name"));
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {TaskService.addTask("1234", "testDescException", "test that checks that addtask throws exception for invalid Description lenght when the length of the description is way to long ");});
		assertTrue(thrown3.getMessage().contains("Invalid Description"));
	}
	
	//Testing that addTask throws exception for null parameters
	@Test
	void testAddTaskNull() {
		IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {TaskService.addTask(null, "testIDException", "test that checks that addtask throws exception for null ID");});
		assertTrue(thrown1.getMessage().contains("Invalid ID"));
		IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {TaskService.addTask("123", null, "test that checks that addtask throws exception for null name");});
		assertTrue(thrown2.getMessage().contains("Invalid Name"));
		IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {TaskService.addTask("1234", "testNUllDescEx", null);});
		assertTrue(thrown3.getMessage().contains("Invalid Description"));
	}
	
	//Testing that deleteTask works correctly;
	@Test
	void testDeleteTask() {
		TaskService.addTask("123", "task1", "Testing deleteTask");
		TaskService.addTask("1234", "task2", "Testing deleteTask");
		TaskService.addTask("12345", "task3", "Testing deleteTask");
		
		assertTrue(TaskService.taskList.size() == 3);
		TaskService.deleteTask("123");
		assertFalse(TaskService.taskList.size() == 3);
	}
	
	//Testing that UpdateName changes name
	@Test
	void testUpdateName() {
		TaskService.addTask("123456", "task1", "Testing Update Name");
		TaskService.updateName("123456", "task2");
		
		for(int i = 0; i < TaskService.taskList.size(); i++) {
			if(TaskService.taskList.get(i).getID() == "123456") {
				assertFalse(TaskService.taskList.get(i).getName() == "task1");
			}
			if(TaskService.taskList.get(i).getID() == "123456") {
				assertTrue(TaskService.taskList.get(i).getName() == "task2");
			}
		}
		TaskService.deleteTask("123456");
	}
	
	//Testing that updateDesc changes description
	@Test
	void testUpdateDesc() {
		TaskService.addTask("12345678", "task1", "Testing update Desc");
		TaskService.updateDesc("12345678", "New Desc");
		
		for(int i = 0; i < TaskService.taskList.size(); i++) {
			if(TaskService.taskList.get(i).getID() == "12345678") {
				assertFalse(TaskService.taskList.get(i).getDesc() == "Testing update Desc");
			}
			if(TaskService.taskList.get(i).getID() == "123456") {
				assertTrue(TaskService.taskList.get(i).getDesc() == "New Desc");
			}
		}
		TaskService.deleteTask("12345678");
	}


}
