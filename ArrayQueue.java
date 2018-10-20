public class ArrayQueue implements Queue {

	public Object[] arr = new Object[10];
	public int head;
	public int tail;

	public ArrayQueue() {
		// Assign default values for queue
		this.head = 0;
		this.tail = 0;
	}
	// Removes the first item that was inputed
	public Object dequeue() {
		if (empty()) {
			// Can't throw exception without changing main class, so returning null
			return null;
		}

		// Put the value in temp
		Object obj = arr[head];

		// Head is now the next value in the array (increment it)
		++head;

		// In case head is greater than the actual length of the array,
		// take the remainder of it by the length of the array
		head = head%arr.length;
		return obj;
	}

	// Adds an item to the queue
	public void enqueue(Object item) {
		// Assign the next availalble position (tail) the new item
		arr[tail++] = item;

		// If tail equals the head, grow the array
		if((tail) % arr.length == head) {
			grow_array();
		// If the tail didn't reach head but it an't go any further, make it 0
		} else if (tail == arr.length) {
		    tail = 0;
        }

	}


	// Checks if the queue is empty
	public boolean empty() {

		// If the head and tail have the same value, the queue is empty
		return this.head == this.tail;

	}

	// Double the size of the array
	public void grow_array() {
		// This is simply, copyign values to a new array
		Object[] temp = new Object[arr.length*2];
		tail = 0;
		for (int i = head; i < arr.length + head; i++) {
			temp[tail++] = arr[i%arr.length];
		}

		// After doing this, the head will be at 0
		head = 0;
		this.arr = temp;
	}
}
