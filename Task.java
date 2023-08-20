package Task;



public class Task {
   
	//initiating variables
	private String taskID;
	public String taskName;
	public String taskDesc;
	
	//Task constructor
	public Task(String ID, String name,String description ) {
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.taskID = ID;
		this.taskName = name;
		this.taskDesc = description;
	}
	
	//Getters for Task ID, Name, and Description
	public String getID() {
		return taskID;
	}
	
	public String getName() {
		return taskName;
	}
	
	public String getDesc() {
		return taskDesc;
	}
	
}
