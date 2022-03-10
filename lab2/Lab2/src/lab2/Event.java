package lab2;

/**
 * The Event class, used to create an object of type Event.
 * @author alinh
 * 
 */
public class Event {

	private String name;
	private int size;
	private int startTime, endTime;
	
	/**
	 * The default constructor.
	 */
	public Event() { }
	
	/**
	 * The constructor used when only given a name for the Event object.
	 * @param name The name of the event.
	 */
	public Event(String name) {
		
		this.name = name;
	}
	
	/**
	 * The constructor that initializes all of the Event object's parameters.
	 * @param name The name of the event.
	 * @param size The maximum student capacity of the event.
	 * @param startTime The starting time of the event.
	 * @param endTime The ending time of the event.
	 */
	public Event(String name, int size, int startTime, int endTime) {
		
		this.name = name;
		this.size = size;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * The name setter function.
	 * @param name The name of the event.
	 */
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * The size setter function.
	 * @param size The maximum student capacity of the event.
	 */
	public void setSize(int size) {
		
		this.size = size;
	}
	
	/**
	 * The start time setter function.
	 * @param startTime The starting time of the event.
	 */
	public void setStartTime(int startTime) {
		
		this.startTime = startTime;
	}
	
	/**
	 * The end time setter function.
	 * @param endTime The ending time of the event.
	 */
	public void setEndTime(int endTime) {
		
		this.endTime = endTime;
	}
	
	/**
	 * The name getter function.
	 * @return The name of the event.
	 */
	public String getName() {
		
		return this.name;
	}
	
	/**
	 * The size getter function.
	 * @return The maximum student capacity of the event.
	 */
	public int getSize() {
		
		return this.size;
	}
	
	/**
	 * The start time getter function.
	 * @return The starting time of the event.
	 */
	public int getStartTime() {
		
		return this.startTime;
	}
	
	/**
	 * The end time getter function.
	 * @return The ending time of the event.
	 */
	public int getEndTime() {
		
		return this.endTime;
	}
	
	/**
	 * Override of the equals operator.
	 * @param obj The object to compare to.
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null || !(obj instanceof Event)) {
			
			return false;
		}
		
		Event other = (Event) obj;
		return name.equals(other.name);
	}
	
	/**
	 * Override of the toString function.
	 */
	@Override
	public String toString() {
		
		 return name + "(" +
				 "size=" + size +
				 ", start=" + startTime +
				 ", end=" + endTime +
				 ")";
	}
	
}
