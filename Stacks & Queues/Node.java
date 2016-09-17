class Node<T> {
        T data;
        Node<T> next;

	Node(T o) {
		this.data = o;
		this.next = null;
	}

        Node(T o, Node<T> next) {
                this.data = o;
                this.next = next;
        }

        public String toString() {
                if ( this.next == null) {
                        return this.data + "|";
                }
                return this.data + ";" + this.next;
        }

	public static int countNodesInList(Node head) {
                if (head == null) {
                        return 0;
                }
                return countNodesInList(head.next) + 1;
        }

	public static Node createList(int[] input) {
                if (input.length == 0) {
                        return null;
                }
                Node<Integer> current = null;
                for(int i = input.length -1; i >= 0; i--) {
                        current = new Node<Integer>(new Integer(input[i]), current);
                }
                return current;
        }

}
