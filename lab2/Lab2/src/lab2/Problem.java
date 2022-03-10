package lab2;

/**
 * The Problem class, describing an instance of the problem.
 * @author alinh
 *
 */
public class Problem {
	
	private Event[] events;
	private Room[] rooms;
	
	/**
	 * The constructor of the Problem object.
	 * @param events The list of events.
	 * @param rooms The list of rooms.
	 */
	public Problem(Event[] events, Room[] rooms) {
		
		this.events = events;
		this.rooms = rooms;
	}
	
	/**
	 * The events setter function.
	 * @param events The list of events.
	 */
	public void setEvents(Event[] events) {
	
		this.events = events;
	}
	
	/**
	 * The rooms setter function.
	 * @param rooms The list of rooms.
	 */
	public void setRooms(Room[] rooms) {
	
		this.rooms = rooms;
	}
	
	/**
	 * The events getter function.
	 * @return The list of events.
	 */
	public Event[] getEvents() {
	
		return events;
	}
	
	/**
	 * The rooms getter function.
	 * @return The list of rooms.
	 */
	public Room[] getRooms() {
	
		return rooms;
	}
}
