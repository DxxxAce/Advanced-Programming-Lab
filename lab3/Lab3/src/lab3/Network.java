package lab3;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The Network class.
 * @author alinh
 *
 */
public class Network {

	private List<Node> nodes;
	
	/**
	 * Class default constructor.
	 */
	public Network() {
		
		this.nodes = new ArrayList<>();
	}
	
	/**
	 * Class constructor.
	 * @param nodes List of nodes.
	 */
	public Network(List<Node> nodes) {
		
		this.nodes = nodes;
	}
	
	/**
	 * Nodes list setter.
	 * @param nodes List of nodes.
	 */
	public void setNodes(List<Node> nodes) {
	
		this.nodes = nodes;
	}
	
	/**
	 * Nodes list getter.
	 * @return List of nodes.
	 */
	public List<Node> getNodes() {
	
		return nodes;
	}
	
	/**
	 * Add node to list.
	 * @param node Object of type Node.
	 */
	public void addNode(Node node) {

		nodes.add(node);
	}
	
	/**
	 * Sort identifiable nodes by address.
	 * @return Sorted identifiable nodes list.
	 */
	public List<Node> sortIdentifiableNodes() {
		
		List<Node> sortedNodes = new ArrayList<>();
		
		for (Node node : nodes) {
			
			if (node instanceof Identifiable) {
				
				sortedNodes.add(node);
			}
		}
		
		sortedNodes.sort(new CompareNodes());
		
		return sortedNodes;
	}
	
	/**
	 * Override of the toString() function.
	 */
	@Override
	public String toString() {
		
		String string = "";
		
		for (Node node : nodes) {
			
			Map<Node, Integer> costs = node.getCosts();
			
			for (Map.Entry<Node, Integer> cost : costs.entrySet()) {
				
				if (node != cost.getKey() && node.getName().compareTo(cost.getKey().getName()) <= 0) {
				
					string += node + "--" + cost.getKey() + '\t' + cost.getValue() + '\n';
				}
			}
		}
		
		return string;
	}
}
