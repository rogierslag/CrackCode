// Write code to remove duplicates from an unsorted linked list

class RemoveDuplicates {

	public static Node removeDuplicates(Node head) {
		if ( head == null ) {
			return null;
		}
		
		int currentValue = head.data;
		Node current = head;
		while(current.next != null ) {
			if ( current.next.data == currentValue ) {
				// Duplicate, skip it
				current.next = current.next.next;
			} else { 
				current = current.next;
			}
		}
		// Now we know the list from here does not contain this value, so we continue recursively
		head.next = removeDuplicates(head.next);
		return head;
	}

	public static void test(Node head) {
		System.out.println("Original=" + head + "; withoutDuplicates=" + removeDuplicates(head));
	}

	public static void main(String[] args) {
		System.out.println(Node.createList(new int[]{0,1,2,3,4}));
		test(Node.createList(new int[0]));
		test(Node.createList(new int[]{0}));
		test(Node.createList(new int[]{0,0}));
		test(Node.createList(new int[]{0,1}));
		test(Node.createList(new int[]{0,1,2,3}));
		test(Node.createList(new int[]{0,1,0,1}));
		test(Node.createList(new int[]{0,1,2,1,0}));
		test(Node.createList(new int[]{0,1,2,3,0,1,2,3,0,1,2,3,4}));
	}

}

// This solution uses recursion, and will first remove all values which are equal to the first node. Then continue with the second etc.
// It will therefore traverse at most all n-1 nodes per iteration to check the current node. This then reduces to O(n).
// Space complexity is equal to O(n) (even upped bounded) since no additional items are allocated. 
