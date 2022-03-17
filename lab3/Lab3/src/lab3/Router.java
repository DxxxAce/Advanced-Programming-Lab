package lab3;

public class Router extends Node implements Identifiable {

	private String address;
	private String mac;
	
	public Router(String name, String address, String mac) {
		
		this.name = name;
		this.address = address;
		this.mac = mac;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public void setAddress(String address) {
	
		this.address = address;
	}
	
	public void setMac(String mac) {
	
		this.mac = mac;
	}
	
	public String getName() {
	
		return name;
	}
	
	@Override
	public String getAddress() {

		return address;
	}
	
	public String getMac() {
	
		return mac;
	}
}
