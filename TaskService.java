package Task;

import java.util.ArrayList;


public class TaskService {
   public static ArrayList<Task> taskList = new ArrayList<Task>();
   
   //function to add new tasks
   public static void addTask(String ID, String name, String desc) {
	   Task newTask = new Task(ID, name, desc);
	   
	   for(int i = 0; i < taskList.size(); i++) {
		   if(ID.equals(taskList.get(i).getID())){
			   throw new IllegalArgumentException("ID already exist");
		   }
	   }
	   taskList.add(newTask);
   }
   
   //Function to delete tasks
   public static void deleteTask(String ID) {
	   for(int i = 0; i < taskList.size(); i++) {
		   if(ID.equals(taskList.get(i).getID())){
			   taskList.remove(i);
		   }
	   }
   }
   
   //Function to update the name of a task.
   public static void updateName(String ID, String name) {
	   if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
	   for(int i = 0; i < taskList.size(); i++) {
		   if(ID.equals(taskList.get(i).getID())){
			   taskList.get(i).taskName = name;
		   }
      }
   }
   
   //Function to update the description of a task
   public static void updateDesc(String ID, String desc) {
	   if(desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
	   for(int i = 0; i < taskList.size(); i++) {   
		   if(ID.equals(taskList.get(i).getID())){
			   taskList.get(i).taskDesc = desc;
		   }
	   }
   }
}
