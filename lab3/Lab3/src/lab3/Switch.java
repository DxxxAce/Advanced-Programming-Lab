package lab3;

public class Switch extends Node implements Identifiable {

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

	@Override
	public String getAddress() {
		
		return null;
	}
	
	@Override
	public boolean isIdentifiable() {
		
		return false;
	}
}
