package lab2;

public class Problem {
	
	final int DEFAULT_SIZE = 2;
	
	private Event[] events;
	private Room[] rooms;

	public Problem() {
		
		this.events = new Event[DEFAULT_SIZE];
		this.rooms = new Room[DEFAULT_SIZE];
	}
	
	public Problem(Event[] events, Room[] rooms) {
		
		this.events = events;
		this.rooms = rooms;
	}
	
	public void setEvents(Event[] events) {
	
		this.events = events;
	}
	
	public void setRooms(Room[] rooms) {
	
		this.rooms = rooms;
	}
	
	public Event[] getEvents() {
	
		return events;
	}
	
	public Room[] getRooms() {
	
		return rooms;
	}
	
	@Override
	public String toString() {
		
		return "Problem: Events {" +
				events + "} Rooms {" +
				rooms +
				"}";
	}
}
