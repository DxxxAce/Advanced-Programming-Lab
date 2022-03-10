package lab2;

public class Event {

	private String name;
	private int size;
	private int startTime, endTime;
	
	public Event() { }
	
	public Event(String name) {
		
		this.name = name;
	}
	
	public Event(String name, int size, int startTime, int endTime) {
		
		this.name = name;
		this.size = size;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public void setSize(int size) {
		
		this.size = size;
	}
	
	public void setStartTime(int startTime) {
		
		this.startTime = startTime;
	}
	
	public void setEndTime(int endTime) {
		
		this.endTime = endTime;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public int getSize() {
		
		return this.size;
	}
	
	public int getStartTime() {
		
		return this.startTime;
	}
	
	public int getEndTime() {
		
		return this.endTime;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null || !(obj instanceof Event)) {
			
			return false;
		}
		
		Event other = (Event) obj;
		return name.equals(other.name);
	}
	
	@Override
	public String toString() {
		
		 return name + "(" +
				 "size=" + size +
				 ", start=" + startTime +
				 ", end=" + endTime +
				 ")";
	}
	
}
