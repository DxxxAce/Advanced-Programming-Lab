package lab3;

import java.util.Comparator;

public class CompareNodes implements Comparator<Node> {

	@Override
	public int compare(Node obj1, Node obj2) {
		
		if (obj1 instanceof Computer && obj2 instanceof Computer) {
			
			return ((Computer)obj1).getAddress().compareTo(((Computer)obj2).getAddress());
		}
		
		if (obj1 instanceof Router && obj2 instanceof Router) {
			
			return ((Router)obj1).getAddress().compareTo(((Router)obj2).getAddress());
		}
		
		if (obj1 instanceof Computer && obj2 instanceof Router) {
			
			return ((Computer)obj1).getAddress().compareTo(((Router)obj2).getAddress());
		}
		
		if (obj1 instanceof Router && obj2 instanceof Computer) {
			
			return ((Router)obj1).getAddress().compareTo(((Computer)obj2).getAddress());
		}
		
		return 0;
	}
}
