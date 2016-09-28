class BalancedTree {

	public static BinNode balance(int[] values) {
		return balance(values, 0, values.length - 1);
	}

	public static BinNode balance(int[] values, int start, int end) {
		if ( start > end ) {
			return null;
		}
		int middle = (end + start) / 2; // always an int
		BinNode left = balance(values, start, middle - 1);
		BinNode right = balance(values, middle + 1, end);
		return new BinNode(left, right, values[middle]);
	}

	public static void test(int[] values) {
		BinNode tree = balance(values);
		int depth = tree.depth();
		System.out.println(String.format("Array of %s yielded a tree of depth %d (%s)", values, depth, tree));
	}

	public static void main(String[] args) {
		test(new int[]{0,1,2}); // 2
		test(new int[]{0,1,2,3,4,5,6}); // 3
		test(new int[]{0,1}); // 2
		test(new int[]{0}); // 1
		test(new int[]{0,1,2,3,4,5,6,7}); // 4
	}	

}
