package lab3;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Network implements Comparable<Node> {

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
	
	public List<Node> sortIdentifiableNodes() {
		
		List<Node> sortedNodes = new ArrayList<>();
		
		for (Node node : nodes) {
			
			if (node instanceof Identifiable) {
				
				sortedNodes.add(node);
			}
		}
		
//		sortedNodes.sort(Comparator<Node>);
		
		return sortedNodes;
	}
	
	@Override
	public String toString() {
		
		String string = "";
		
		for (Node node : nodes) {
			
			Map<Node, Integer> costs = node.getCosts();
			
			for (Map.Entry<Node, Integer> cost : costs.entrySet()) {
				
				if (node != cost.getKey()) {
				
					string += node + "--" + cost.getKey() + '\t' + cost.getValue() + '\n';
				}
			}
		}
		
		return string;
	}

	@Override
	public int compareTo(Node other) {

		
		return 0;
	}
}
