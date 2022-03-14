package lab3;

public class Switch extends Node {

	private String location;
	
	public Switch(String name, String location) {
		
		this.name = name;
		this.location = location;
	}
	
	
	public void setLocation(String location) {
	
		this.location = location;
	}
	
	
	public String getLocation() {
	
		return location;
	}
	
	public boolean isIdentifiable() {
		
		return false;
	}
}
