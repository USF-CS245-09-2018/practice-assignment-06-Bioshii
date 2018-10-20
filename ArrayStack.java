public class ArrayStack implements Stack {
	public Object[] arr;
	public int top;

	public ArrayStack () {
		arr = new Object[10];
		top = -1;
	}

	public void push(Object item) {
		if (top + 1 >= arr.length) {
			grow_array();
		}
		arr[++top] = item;
	}

	// Remove the item on top of the stack
	public Object pop() {
		if (!empty()) {
			return arr[top--];
		}

		return null;
	}

	// Returns the object at the to pof the stack
	public Object peek() {
		if (!empty()) {
			return arr[top];
		} else {
			return null;
		}
	}

	// Returns true if there are no items in the stack, false otherwise
	public boolean empty() {
		if (top == -1)
			return true;
		return false;
	}

	// Double the size of the array
	public void grow_array() {
		Object[] temp = new Object[arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		arr = temp;
	}
}
