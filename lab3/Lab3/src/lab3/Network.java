package lab3;

import java.util.List;
import java.util.ArrayList;

public class Network {

	private List<Node> nodes;
	
	public Network() {
		
		this.nodes = new ArrayList<>();
	}
	
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
		
		return nodes + "";
	}
}
