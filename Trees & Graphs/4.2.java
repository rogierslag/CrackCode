// Given a direxted graph, design an algorithm to find out whether there is a route between two nodes

class RouteFinding {

	public static GraphNode[] visited = new GraphNode[100];
	public static int visitedPointer = 0;

	public static boolean isRouteBetween(GraphNode start, GraphNode end) {
		if(start == null || end == null) {
			System.err.println("Input was null");
			return false;
		}
		if(start == end) {
			return true;
		}
		for(int i = 0; i < start.reachableNodes.length; i++) {
			GraphNode nextNode = start.reachableNodes[i];
			if(nextNode == null || !isNewNode(nextNode)) {
				continue;
			}
			if ( isRouteBetween(nextNode, end)) {
				return true;
			}			
		}
		return false;
	}

	public static boolean isNewNode(GraphNode n) {
		for(int i = 0; i < visitedPointer; i++) {
			if(visited[i] == n) {
				System.err.println("Node has been visited before");
				return false;
			}
		}
		return true;
	}

	public static void addNode(GraphNode n) {
		visited[visitedPointer] = n;
		visitedPointer++;
	}

	public static void main(String[] args) {
		GraphNode n = new GraphNode("n");
		GraphNode e = new GraphNode("e");
		System.out.println(isRouteBetween(n,e)); // false
		n.reachableNodes[0] = e;
		System.out.println(isRouteBetween(n,e)); // true
		n.reachableNodes = new GraphNode[100];
		e.reachableNodes[0] = n;
		System.out.println(isRouteBetween(n,e)); // false

		e = new GraphNode("end");
		GraphNode x = new GraphNode("x", e);
		n = new GraphNode("start", new GraphNode("d1"), new GraphNode("d2"), new GraphNode("d3"), x);
		System.out.println(isRouteBetween(n,e));
	}
}
