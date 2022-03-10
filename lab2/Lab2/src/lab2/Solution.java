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
	 * Function to compute the number of used rooms.
	 * @return The number of used rooms.
	 */
	 public int computeUsedRooms() {
		
		 return assignment.length;
	 }
}
