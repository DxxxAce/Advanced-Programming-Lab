package lab3;

public class Switch extends Node {

	private String name;
	private String location;
	
	public Switch(String name, String location) {
		
		this.name = name;
		this.location = location;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public void setLocation(String location) {
	
		this.location = location;
	}
	
	public String getName() {
	
		return name;
	}
	
	public String getLocation() {
	
		return location;
	}
	
	@Override
    public String toString() {
        return  name;
    }
}
