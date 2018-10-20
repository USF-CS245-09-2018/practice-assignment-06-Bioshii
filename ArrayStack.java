public class ArrayStack implements Stack {
	public Object[] arr;
	public int top;

	public ArrayStack () {
		arr = new Object[10];
		// -1 top means the stack is empty
		top = -1;
	}

	public void push(Object item) {
		// If the top is greater than array lenght, make it bigger
		if (top + 1 >= arr.length) {
			grow_array();
		}
		arr[++top] = item;
	}

	// Remove the item on top of the stack
	public Object pop() {
		// As long as the array isn't empty return the most recent item
		if (!empty()) {
			return arr[top--];
		}

		// If it is, typically throw exception, but return null for now
		return null;
	}

	// Returns the object at the to pof the stack
	public Object peek() {
		// Make sure there's something to peek at
		if (!empty()) {
			return arr[top];
		} else {
			// Would throw exceptoin here typically
			return null;
		}
	}

	// Returns true if there are no items in the stack, false otherwise
	public boolean empty() {
		// If top is -1 that means it is empty
		if (top == -1)
			return true;
		return false;
	}

	// Double the size of the array
	public void grow_array() {
		// Copy values over to larger aray with double the values
		Object[] temp = new Object[arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		arr = temp;
	}
}
