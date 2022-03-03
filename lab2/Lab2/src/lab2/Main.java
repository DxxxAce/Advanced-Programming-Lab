package lab2;

public class Main {

	public static void main(String[] args) {
		
		Event c1 = new Event();
		c1.setName("C1");
		c1.setSize(100);
		c1.setStartTime(8);
		c1.setEndTime(10);
		System.out.println(c1);
		
		Event c2 = new Event("C2", 100, 10, 12);
		System.out.println(c2);
		
		Event l1 = new Event("L1", 30, 8, 10);
		System.out.println(l1);
		
		Event l2 = new Event("L2", 30, 8, 10);
		System.out.println(l2);
		
		Event l3 = new Event("L3", 30, 10, 12);
		System.out.println(l3);
		
		Room r1 = new Room("401", 30, RoomType.COMPUTER_LAB);
		System.out.println(r1);
		
		Room r2 = new Room("403", 30, RoomType.COMPUTER_LAB);
		System.out.println(r2);
		
		Room r3 = new Room("405", 30, RoomType.COMPUTER_LAB);
		System.out.println(r3);
		
		Room r4 = new Room("309", 100, RoomType.LECTURE_HALL);
		System.out.println(r4);
	}
}
