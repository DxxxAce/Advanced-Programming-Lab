package lab2;

/**
 * The Solution class, describing a solution for the instance of the problem.
 * @author alinh
 *
 */
public class Solution {

	private Room[] assignment;
	private final Event[] EVENTS;
	 //assignment[i] = what room received the event with index i

	/**
	 * The constructor of the Solution class.
	 * @param events The events to which the rooms are assigned.
	 */
	Solution(Event[] events) {
		
		this.assignment = new Room[events.length];
		this.EVENTS = events;
	}
	
	/**
	 * The room assignment setter function.
	 * @param assignment The assigned rooms.
	 */
	public void setAssignment(Room[] assignment) {
	
		this.assignment = assignment;
	}
	
	/**
	 * The room assignment getter function.
	 * @return The assigned rooms.
	 */
	public Room[] getAssignment() {
	
		return assignment;
	}
	
	/**
	 * Function that assigns a room to an event.
	 * @param room The room to be assigned to the event.
	 * @param i The index of the event.
	 */
	public void assignRoom(Room room, int i) {
		
		assignment[i] = room;
	}
	/**
	 * Function to compute the number of used rooms.
	 * @return The number of used rooms.
	 */
	 public int computeUsedRooms() {
		
		 int count = 0;
		 Room[] countedRooms = new Room[assignment.length];
		 boolean counted;
		 
		 for (int i = 0; i < assignment.length; i++) {
			 
			 counted = false;
			 
			 for (int j = 0; j < countedRooms.length && !counted; j++) {
				 
				 if (assignment[i] == countedRooms[j]) {
					 
					 counted = true;
				 }
			 }
			 
			 if (!counted) {
				 
				 countedRooms[count] = assignment[i];
				 count++;
			 }
		 }
		 
		 return count;
	 }
	 
	 /**
	  * Override of the toString function.
	  */
	 @Override
	public String toString() {
		
		String string = "Assigned:\n";
		
		for (int i = 0; i < assignment.length; i++) {
			
			string += EVENTS[i].getName() + " - " + assignment[i].getName() + "\n";
		}
		
		return string;
	}
}
