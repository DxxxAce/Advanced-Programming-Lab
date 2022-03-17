package lab3;

/**
 * Computer class.
 * @author alinh
 *
 */
public class Computer extends Node implements Identifiable, Storage {

	private String address;
	private int storageCapacity;
	
	/**
	 * Class constructor.
	 * @param name Name.
	 * @param address IP Address.
	 * @param storageCapacity  Total storage capacity.
	 */
	public Computer(String name, String address, int storageCapacity) {
		
		this.name = name;
		this.address = address;
		this.storageCapacity = storageCapacity;
	}
	
	/**
	 * Address setter.
	 * @param address IP address.
	 */
	public void setAddress(String address) {
	
		this.address = address;
	}
	
	/**
	 * Storage capacity setter
	 * @param storageCapacity Storage capacity value.
	 */
	public void setStorageCapacity(int storageCapacity) {
	
		this.storageCapacity = storageCapacity;
	}
	
	/**
	 * Address getter.
	 * @return IP address.
	 */
	@Override
	public String getAddress() {
		
		return this.address;
	}
	
	/**
	 * Storage capacity getter.
	 * @return Storage capacity value.
	 */
	@Override
	public int getStorageCapacity() {
	
		return storageCapacity;
	}
}
