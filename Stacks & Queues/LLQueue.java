// Simple Queue using a LinkedList. We enqueue at the back, and dequeue from the front
class LLQueue<T> {

	Node<T> first;
	Node<T> last;

	public void enqueue(T o) {
		if(first == null) {
			first = new Node<T>(o);
			last = first;
		}
		else {
			Node<T> n = new Node<T>(o);
			last.next = n;
			last = n;
		}
	}

	public T dequeue() {
		if(first == null) {
			return null;
		}
		Node<T> current = first;
		first = first.next;
		return current.data;
	}

	public boolean isEmpty() {
		return first == null;
	}
}
