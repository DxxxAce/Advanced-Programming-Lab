package lab2;

/**
 * The GreedyAlgorithm class, derived from the Algorithm superclass. Used to create a greedy algorithm that solves the problem.
 * @author alinh
 *
 */
public class GreedyAlgorithm extends Algorithm {

	private Problem pb;
	
	/**
	 * The constructor of the GreedyAlgorithm class.
	 * @param pb The instance of the problem.
	 */
	public GreedyAlgorithm(Problem pb) {

		this.pb = pb;
	}
	
	/**
	 * Override of the solve method, inherited from the superclass. Solves the problem for a given instance.
	 * @param pb The instance of the problem.
	 * @return A solution for the given instance of the problem.
	 */
	@Override
	public Solution solve(Problem pb) {
		
		Solution sol = new Solution();
		
		Event[] events = pb.getEvents();
		Room[] rooms = pb.getRooms();
		
		int i, j;
		
		for (i = 0; i < events.length; i++) {
			
			for (j = 0; j < rooms.length; j++) {
				
				if (events[i].getSize() <= rooms[j].getCap()) {
					
					sol.assignRoom(i, rooms[j]);
					break;
				}
			}
		}
		
		return null;
	}
}
