package lab3;

/**
 * Switch class.
 * @author alinh
 *
 */
public class Switch extends Node {

	private String location;
	
	/**
	 * Class constructor.
	 * @param name Name.
	 * @param location Physical location.
	 */
	public Switch(String name, String location) {
		
		this.name = name;
		this.location = location;
	}
	
	/**
	 * Location setter.
	 * @param location Physical location.
	 */
	public void setLocation(String location) {
	
		this.location = location;
	}
	
	/**
	 * Location getter.
	 * @return Physical location.
	 */
	public String getLocation() {
	
		return location;
	}
}
