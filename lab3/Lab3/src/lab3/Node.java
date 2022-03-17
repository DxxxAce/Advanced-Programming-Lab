package lab3;

import java.util.Map;
import java.util.HashMap;

public class Node implements Comparable<Node> {

	protected String name;
	protected Map<Node, Integer> costs = new HashMap<>();
	
	public Node() {

		costs.put(this, null);
	}

	public void setName(String name) {
	
		this.name = name;
	}
	
	public void setCost(Node node, int value) {
		
		costs.put(node, value);
		node.costs.put(this, value);
	}
	
	public String getName() {
	
		return name;
	}
	
	public Map<Node, Integer> getCosts() {
	
		return costs;
	}
	
	@Override
	 public int compareTo(Node other) {
		
		return this.name.compareTo(other.name);
	 }

	
	@Override
	public String toString() {

		return name;
	}
}
