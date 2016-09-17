// Implement an alogirthm to find the nth to last element of a singly linked list

class FindNthElement {

	public static Node findNthElementFromFront(Node head, int n) {
		if (n <= 0) {
			return head;
		}
		if (head == null) {
			return null;
		}
		return findNthElementFromFront(head.next, n-1);
	}

	public static Node findNthElementFromBack(Node head, int n) {
		// This one is a lot trickier. Imagine we have a linked list as [1,2,3,4] and use n = 1. We want a result of 3 (which links to 4)
		// What we do is the following. We keep two nodes in reference: n1 and n2. We will advance n2 by n such that is always n elements in
		// front of n1. Once we encounter that n2 has ended, we know that n1 is n elements back, which is the element we need

		if(head == null || n < 0) {
			return null;
		}
		Node n1 = head;
		Node n2 = head;
		for(int i = 0; i < n; i++) {
			if(n2.next == null) {
				// cannot be done
				return null;
			}
			n2 = n2.next;
		}
		// Now we advance both n1 and n2, once n2 encounters the end, n1 is in the correct position
		while(n2.next != null) {
			n1 = n1.next; // we are sure this exists, since n2 already passed it
			n2 = n2.next;
		}
		return n1;
	}

	public static void testFront(Node head, int element) {
		System.out.println("Original='" + head + "'; elementFromFront=" + element + "; found='" + findNthElementFromFront(head, element) + "'");
	}

	public static void testBack(Node head, int element) {
		System.out.println("Original='" + head + "'l elementFromBack=" + element + "; found='" + findNthElementFromBack(head, element) + "'");
	}

	public static void main(String[] args) {
		testFront(Node.createList(new int[]{}), 0);
		testFront(Node.createList(new int[]{0}), 0);
		testFront(Node.createList(new int[]{1,0}), 0);
		testFront(Node.createList(new int[]{1,0}), 1);
		testFront(Node.createList(new int[]{1,2,3,4}), 0);
		testFront(Node.createList(new int[]{1,2,3,4}), 3);
		testFront(Node.createList(new int[]{1,2,3,4}), 1);	

                testBack(Node.createList(new int[]{}), 0);
                testBack(Node.createList(new int[]{0}), 0);
                testBack(Node.createList(new int[]{1,0}), 0);
                testBack(Node.createList(new int[]{1,0}), 1);
                testBack(Node.createList(new int[]{1,2,3,4}), 0);
                testBack(Node.createList(new int[]{1,2,3,4}), 3);
                testBack(Node.createList(new int[]{1,2,3,4}), 1);
		testBack(Node.createList(new int[]{1,2,3,4}), 12);
	}
}
// Both complexities in time are O(n) since we traverse the entire list at most once.
// Space complexity is equal to the size of the list, hence O(n) as well
// Note that the findNthElementFromFront may result in too deep stack levels at some point
