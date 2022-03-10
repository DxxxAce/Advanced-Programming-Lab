package lab2;

/**
 * The Main class, where the main function is implemented. 
 * @author alinh
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		Event c1 = new Event();
		c1.setName("C1");
		c1.setSize(100);
		c1.setStartTime(8);
		c1.setEndTime(10);
		Event c2 = new Event("C2", 100, 10, 12);
		
		Event l1 = new Event("L1", 30, 8, 10);
		Event l2 = new Event("L2", 30, 8, 10);
		Event l3 = new Event("L3", 30, 10, 12);
		
		Room r1 = new ComputerLab("401", 30, OperatingSystem.WINDOWS10);
		Room r2 = new ComputerLab("403", 30, OperatingSystem.WINDOWS10);
		Room r3 = new ComputerLab("405", 30, OperatingSystem.UBUNTU);
		Room r4 = new LectureHall("309", 100, true);
		
		Event[] events = {c1, c2, l1, l2, l3};
		Room[] rooms = {r1, r2, r3, r4};
		
		Problem pb = new Problem(events, rooms);
		
		Algorithm greedy = new GreedyAlgorithm(pb);
		Solution sol = greedy.solve(pb);
		System.out.println(sol);
		
		System.out.println(pb);
	}
}
