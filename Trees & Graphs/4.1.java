class TreeBalance {

	public static int maxDepth(BinNode node) {
		if(node == null) {
			return 0;
		}
		return 1+Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	public static int minDepth(BinNode node) {
		if( node == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}

	public static boolean isBalancedTree(BinNode rootNode) {
		int max = maxDepth(rootNode);
		int min = minDepth(rootNode);
		return max - min <= 1;
	}
}
