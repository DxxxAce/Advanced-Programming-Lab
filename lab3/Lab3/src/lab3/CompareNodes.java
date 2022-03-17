package lab3;

import java.util.Comparator;

/**
 * CompareNodes class.
 * @author alinh
 *
 */
public class CompareNodes implements Comparator<Node> {

	/**
	 * Override of the compare() function.
	 * @param obj1 First object to be compared.
	 * @param obj2 Second object to be compared.
	 * @return Comparison of the two objects.
	 */
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
