class StackWithMin {

	private CrazyStack<Integer> stack;
	private CrazyStack<Integer> mins;

	public StackWithMin() {
		this(5);
	}

	public StackWithMin(int stackSize) {
		stack = new CrazyStack<Integer>(1, stackSize);
		mins = new CrazyStack<Integer>(1, stackSize);
	}

	public Integer pop() {
		mins.pop(0);
		return stack.pop(0);
	}

	public void push(Integer i) {
		if ( mins.isEmpty(0) || mins.peek(0) > i) {
			mins.push(0, i);
		} else {
			mins.push(0, mins.peek(0));
		}
		stack.push(0, i);
	}

	public Integer min() {
		if ( mins.isEmpty(0)) {
			return Integer.MAX_VALUE;
		}
		return mins.peek(0);
	}

	public String toString() {
		return "<" + stack + ";" + mins + ">";
	}

	public static void main(String[] args) {
		StackWithMin m = new StackWithMin();
		m.push(12);
		m.push(2);
		m.push(5);
		m.push(3);
		System.out.println(m);
		System.out.println(m.min()); // 2
		m.push(0);
		System.out.println(m.min()); // 0
		m.pop();
		System.out.println(m.min()); // 2
	}
	

}


