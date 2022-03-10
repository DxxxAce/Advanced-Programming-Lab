package lab3;

import java.util.*;

public class Network {

	private List<Node> nodes = new ArrayList<>();
	
	public Network(List<Node> nodes) {
		
		this.nodes = nodes;
	}
	
	public void setNodes(List<Node> nodes) {
	
		this.nodes = nodes;
	}
	
	public List<Node> getNodes() {
	
		return nodes;
	}
	
	public void addNode(Node node) {

		nodes.add(node);
	}
	
	@Override
	public String toString() {
		
		String string = new String();
		
		for (int i = 0; i < nodes.size(); i++) {
			
			string += nodes.at.toString;
		}
	}
}
