package lab2;

/**
 * The GreedyAlgorithm class, derived from the Algorithm superclass. Used to create a greedy algorithm that solves the problem.
 * @author alinh
 *
 */
public class GreedyAlgorithm extends Algorithm {
	
	/**
	 * The constructor of the GreedyAlgorithm class.
	 * @param pb The instance of the problem.
	 */
	public GreedyAlgorithm(Problem pb) {

		this.pb = pb;
	}
	
	/**
	 * The problem setter function.
	 * @param pb An instance of the problem.
	 */
	public void setPb(Problem pb) {
	
		this.pb = pb;
	}
	
	/**
	 * The problem getter function.
	 * @return An instance of the problem.
	 */
	public Problem getPb() {
	
		return pb;
	}
	
	/**
	 * Override of the solve method, inherited from the superclass. Solves the problem for a given instance.
	 * @param pb The instance of the problem.
	 * @return A solution for the given instance of the problem.
	 */
	@Override
	public Solution solve() {
		
		Solution sol = new Solution(pb.getEvents());
		
		Event[] events = pb.getEvents();
		Room[] rooms = pb.getRooms();
		
		int endTime;
		
		for (int i = 0; i < rooms.length; i++) {
			
			endTime = -1;
			
			for (int j = 0; j < events.length; j++) {
				
				if (sol.getAssignment()[j] == null && rooms[i].getCap() >= events[j].getSize() && events[j].getStartTime() >= endTime) {
					
					sol.assignRoom(rooms[i], j);
					endTime = events[j].getEndTime();
				}
			}
		}
		
		return sol;
	}
}
