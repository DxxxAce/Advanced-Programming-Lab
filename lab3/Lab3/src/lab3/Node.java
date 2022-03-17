package lab3;

import java.util.Map;
import java.util.HashMap;

/**
 * Node class.
 * @author alinh
 *
 */
public class Node implements Comparable<Node> {

	protected String name;
	protected Map<Node, Integer> costs = new HashMap<>();
	
	/**
	 * Class constructor.
	 */
	public Node() {

		costs.put(this, null);
	}

	/**
	 * Name setter.
	 * @param name Name of the node.
	 */
	public void setName(String name) {
	
		this.name = name;
	}
	
	/**
	 * Cost to other node setter.
	 * @param node Other node.
	 * @param value Cost.
	 */
	public void setCost(Node node, int value) {
		
		costs.put(node, value);
		node.costs.put(this, value);
	}
	
	/**
	 * Name getter.
	 * @return The name of the node.
	 */
	public String getName() {
	
		return name;
	}
	
	/**
	 * Costs getter.
	 * @return List of costs to other nodes.
	 */
	public Map<Node, Integer> getCosts() {
	
		return costs;
	}
	
	/**
	 * Override of compareTo() function.
	 * @param other Node to be compared to.
	 */
	@Override
	 public int compareTo(Node other) {
		
		return this.name.compareTo(other.name);
	 }

	/**
	 * Override of toString() function.
	 */
	@Override
	public String toString() {

		return name;
	}
}
