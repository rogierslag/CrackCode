// Vey basic Stack implementation using a LinkedList

class LLStack<T> {

	Node<T> head;

	public void push(T o) {
		head = new Node<T>(o, head);
	}

	public T pop() {
		if ( head == null) {
			return null;
		}
		Node<T> n = head;
		head = head.next;
		return n.data;
	}

	public T peek() {
		if ( head == null) {
			return null;
		}
		return head.data;
	}

	public boolean isEmpty() {
		return head == null;
	}
		
}
