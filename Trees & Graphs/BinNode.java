class BinNode {

	BinNode left;
	BinNode right;
	Object value;

	public BinNode(BinNode left, BinNode right, Object value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public String toString() {
		return String.format("<value=%s; left=%s; right=%s>", value, left, right);
	}

	public int depth() {
		int rightDepth = 0;
		if( right != null) {
			rightDepth = right.depth();
		}

		int leftDepth = 0;
		if( left != null) {
			leftDepth = left.depth();
		}
		return 1 + Math.max(rightDepth, leftDepth);
	}
}
