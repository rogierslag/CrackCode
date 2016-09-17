// Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node

class DeleteMiddle {

	public static Node deleteMiddle(Node head) {
		int length = Node.countNodesInList(head);
		int elementToDelete = length / 2;
		Node elementToBeDeleted = FindNthElement.findNthElementFromFront(head, elementToDelete);
		// We wont delete the element, but we simply copy the next element in here, and change its next pointer
		elementToBeDeleted.data = elementToBeDeleted.next.data;
		elementToBeDeleted.next = elementToBeDeleted.next.next;
		return head;
	}

	public static void test(Node head) {
		try {
			System.out.println("Original='" + head + "'; withMiddleDeleted='" + deleteMiddle(head) + "'");
		} catch (Throwable e) {
			System.out.println("Original='" + head + "'; withMiddleDeleted='ACTION CANNOT BE PERFORMED'");
		}
	}

	public static void main(String[] args) {
		test(Node.createList(new int[]{}));
		test(Node.createList(new int[]{0}));
		test(Node.createList(new int[]{0,1,2}));
		test(Node.createList(new int[]{0,1,2,3}));
		test(Node.createList(new int[]{0,1,2,3,4}));
	}
}

// In order to find out the total number of nodes, we traverse the entire list, which takes O(n) time
// Additionally we then find the correct node in O(n/2) time
// Modifying the pointer takes O(1) time. Combined this yields a time complexity of O(n)
 
