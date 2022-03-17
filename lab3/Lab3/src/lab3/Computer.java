package lab3;

public class Computer extends Node implements Identifiable, Storage {

	private String address;
	private int storageCapacity;
	
	public Computer(String name, String address, int storageCapacity) {
		
		this.name = name;
		this.address = address;
		this.storageCapacity = storageCapacity;
	}
	
	public void setAddress(String address) {
	
		this.address = address;
	}
	
	public void setStorageCapacity(int storageCapacity) {
	
		this.storageCapacity = storageCapacity;
	}
	
	@Override
	public String getAddress() {
		
		return this.address;
	}
	
	@Override
	public int getStorageCapacity() {
	
		return storageCapacity;
	}
}
