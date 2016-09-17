import java.util.Arrays; // just for the toString

// Describe how you could use a single array to implement three stacks
// This went a bit into the extreme with generics
class CrazyStack<T> {

	private final int stackSize;

	// Javas type system does not allow you to create T[], hence we use a generic Object array
	private final Object[] stack;
	private final int[] stackPointers;

	CrazyStack(int stacks, int stackSize) {
		this.stackSize = stackSize;
		this.stack = new Object[stacks*stackSize];
		stackPointers = new int[stacks];
		for(int i = 0; i < stacks; i++) {
			stackPointers[i] = -1;
		}
	}

	@SuppressWarnings("unchecked")
	public T pop(int stackNum) {
		if ( stackNum >= stackPointers.length ) {
			System.err.println("Not a valid stackNum");
			return null;
		}
		if( stackPointers[stackNum] < 0) {
			System.err.println("No elements remaining");
			return null;
		}
		int pointer = stackPointers[stackNum] + stackSize * stackNum;
		T value = (T)stack[pointer];
		stack[pointer] = null;
		stackPointers[stackNum]--;
		if ( stackPointers[stackNum] < 0) {
			stackPointers[stackNum] = -1;
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	public T peek(int stackNum) {
		if(stackNum >= stackPointers.length) {
			System.err.println("Not a valid stackNum");
			return null;
		}
		if(stackPointers[stackNum] < 0) {
			System.err.println("No elements remaining");
			return null;
		}
		return (T)stack[stackPointers[stackNum + stackSize*stackNum]];
	}

	public void push(int stackNum, T value) {
		if(stackNum >= stackPointers.length) {
			System.err.println("Not a valid stackNum");
			return;
		}
		if ( stackPointers[stackNum]+1 >= stackSize) {
			System.err.println("Out of stack space");
			return;
		}
		int pointer = stackPointers[stackNum] + stackSize * stackNum;
		stack[pointer+1] = value;
		stackPointers[stackNum]++;
	}

	public boolean isEmpty(int stackNum) {
		if(stackNum >= stackPointers.length) {
			System.err.println("Not a valid stackNum");
			return false;
		}
		return stackPointers[stackNum] == -1;
	}

	public String toString() {
		return "Stacks=" + stackSize + "; pointers=" + Arrays.toString(stackPointers) + "; data=" + Arrays.toString(stack);
	}

	public static void main(String[] args) {
		CrazyStack<Integer> stack = new CrazyStack<Integer>(1, 1);
		stack.push(0, 3);
		stack.push(0, 4);
		System.out.println(stack); // should just return 3, since the 4 could not be added
	
		stack.pop(0);
		System.out.println(stack); // just one null item

		stack.pop(0);	// returns null and notifies the stack is empty
		stack.pop(1);	// Return null since its an invalid stack number

		System.out.println("Next stack");
		stack = new CrazyStack<Integer>(2,5);
		stack.push(0,0);
		stack.push(0,1);
		stack.push(0,2);
		stack.push(0,3);
		System.out.println(stack.peek(0));
		System.out.println(stack.peek(1));
		stack.push(0,4);
		System.out.println(stack);	// Should have filled the first stack completely
		stack.push(0,5);		// Out of stack space notice
		System.out.println(stack);	// The stack should not have overflown

		System.out.println("Second stack");
		stack.push(1,2);		
		System.out.println(stack);
		for(int i = 0; i < 5; i++) {
			System.out.println(stack.pop(0));
		}
		System.out.println(stack);
	}
}
