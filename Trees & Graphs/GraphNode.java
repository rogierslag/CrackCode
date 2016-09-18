// A node for in a directed graph which can only hold a max of 100 connections
class GraphNode {

	// The nodes we can reach from this one
	GraphNode[] reachableNodes;

	String name;

	GraphNode(String name) {
		this.name = name;
		this.reachableNodes = new GraphNode[100];
	}

	GraphNode(String name, GraphNode... reachableNodes) {
		this(name);
		for(int i = 0; i < reachableNodes.length; i++) {
			this.reachableNodes[i] = reachableNodes[i];
		}
	}
}
