package lab3;

import java.util.Map;
import java.util.HashMap;

public class Node implements Comparable<Node> {

	private String name;
	private Map<Node, Integer> cost = new HashMap<>();

	public void setName(String name) {
	
		this.name = name;
	}
	
	public void setCost(Node node, int value) {
	
		cost.put(node, value);
	}
	
	public String getName() {
	
		return name;
	}
	
	public Map<Node, Integer> getCost() {
	
		return cost;
	}
	
	@Override
	 public int compareTo(Node other) {
		
		return this.name.compareTo(other.name);
	 }

}
