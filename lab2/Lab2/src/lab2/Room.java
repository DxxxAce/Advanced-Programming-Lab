package lab2;

public class Room {
	
	private String name;
	private int cap;
	private RoomType type;
	
	public Room(String name, int cap, RoomType type) {
		
		this.name = name;
		this.cap = cap;
		this.type = type;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	private void setCap(int cap) {
		
		this.cap = cap;
	}
	
	public void setType(RoomType type) {
		
		this.type = type;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public int getCap() {
		
		return this.cap;
	}
	
	public RoomType getType() {
		
		return this.type;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null || !(obj instanceof Room)) {
			return false;
		}
	 
		Room other = (Room) obj;
		return name.equals(other.name);
	}
	
	@Override
	public String toString() {
		
		 return "Room{" +
				 "name=" + name +
				 ", cap=" + cap +
				 ", type=" + type +
				 "}";
	}
}
