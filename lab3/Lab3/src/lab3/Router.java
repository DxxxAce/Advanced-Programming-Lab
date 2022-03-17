package lab3;

/**
 * Router class.
 * @author alinh
 *
 */
public class Router extends Node implements Identifiable {

	private String address;
	private String mac;
	
	/**
	 * Class constructor.
	 * @param name Name.
	 * @param address IP address.
	 * @param mac MAC address.
	 */
	public Router(String name, String address, String mac) {
		
		this.name = name;
		this.address = address;
		this.mac = mac;
	}
	
	/**
	 * Name setter.
	 * @param name Name.
	 */
	public void setName(String name) {
	
		this.name = name;
	}
	
	/**
	 * Address setter.
	 * @param address IP address.
	 */
	public void setAddress(String address) {
	
		this.address = address;
	}
	
	/**
	 * MAC setter.
	 * @param mac MAC address.
	 */
	public void setMac(String mac) {
	
		this.mac = mac;
	}
	
	/**
	 * Name getter.
	 * @return Name.
	 */
	public String getName() {
	
		return name;
	}
	
	/**
	 * Address getter.
	 * @return IP address.
	 */
	@Override
	public String getAddress() {

		return address;
	}
	
	/**
	 * MAC getter.
	 * @return MAC address.
	 */
	public String getMac() {
	
		return mac;
	}
}
