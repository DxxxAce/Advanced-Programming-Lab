package lab2;

/**
 * The Room abstract class, used to create an object of type Room.
 * @author alinh
 *
 */
public abstract class Room {
	
	protected String name;
	protected int cap;
	
	/**
	 * The name setter function.
	 * @param name The name of the room.
	 */
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * The capacity setter function.
	 * @param cap The maximum student capacity of the room.
	 */
	private void setCap(int cap) {
		
		this.cap = cap;
	}
	
	/**
	 * The name getter function.
	 * @return The name of the room.
	 */
	public String getName() {
		
		return this.name;
	}
	
	/**
	 * The capacity getter function.
	 * @return The maximum student capacity of the room.
	 */
	public int getCap() {
		
		return this.cap;
	}

	/**
	 * Override of the equals operator.
	 * @param obj The object to compare to.
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null || !(obj instanceof Room)) {
			
			return false;
		}
	 
		Room other = (Room) obj;
		return name.equals(other.name);
	}
}
