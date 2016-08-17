package deptlibrary.model;

public class JobsEntry {
	
	int id;
	
	String position;
	
	String name;
	
	String date;
	
	public JobsEntry(){}
	
	public JobsEntry(int id, String position, String name, String date){
		
		this.id = id;
		this.position = position;
		this.name = name;
		this.date = date;
	}
	
	public JobsEntry(int id, String position){
		
		this.id = id;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
