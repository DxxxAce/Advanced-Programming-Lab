package lab2;

/**
 * The Solution class, describing a solution for the instance of the problem.
 * @author alinh
 *
 */
public class Solution {

	private Room[] assignment;
	 //assignment[i] = what room received the event with index i

	/**
	 * The default constructor of the Solution class.
	 */
	Solution() {}
	
	/**
	 * Function that assigns a room to an event.
	 * @param i The index of the event.
	 * @param room The room to be assigned to the event.
	 */
	public void assignRoom(int i, Room room) {
		
		assignment[i] = room;
	}
	/**
	 * Function to compute the number of used rooms.
	 * @return The number of used rooms.
	 */
	 public int computeUsedRooms() {
		
		 return assignment.length;
	 }
}
