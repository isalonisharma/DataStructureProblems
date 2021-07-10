package problems;

import java.util.NoSuchElementException;

public class PriorityQueueImplementationUsingArray {
	private int[] innerArray;
	private int size = 0;

	PriorityQueueImplementationUsingArray(int size) {
		this.innerArray = new int[size];
		this.size = 0;
	}

	boolean isEmpty() {
		return size == 0;
	}

	int size() {
		return size;
	}

	int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		} else {
			return innerArray[0];
		}
	}

	boolean contains(int x) {
		if (isEmpty()) {
			return false;
		} else {
			for (int i : innerArray) {
				if (i == x) {
					return true;
				}
			}
			return false;
		}
	}
	
	void doubleArray() {
		int[] newArr = new int[innerArray.length * 2];
		for (int i = 0; i < innerArray.length; i++) {
			newArr[i] = innerArray[i];
		}
		innerArray = newArr;
	}

	void enqueue(int x) {
		if (size == 0) {
			size++;
			innerArray[0] = x;
			System.out.println("Data inserted in priority queue: " + x);
			return;
		} 
		
		if (size() == innerArray.length) {
			doubleArray();
		}
		int temp = x;
		
		for (int i = 0; i < size; i++) {
			
			if (x <= innerArray[i]) {
				int next;
				temp = innerArray[i];
				innerArray[i] = x;
				
				while (i < size - 1) {
					next = innerArray[i + 1];
					innerArray[i + 1] = temp;
					temp = next;
					i++;
				}
				
				break;
			}
			
		}
		innerArray[size] = temp;
		size++;
		System.out.println("Data inserted in priority queue: " + x);
	}

	int dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
		int retValue = innerArray[0];
		for (int i = 1; i < size; i++) {
			innerArray[i - 1] = innerArray[i];
		}
		innerArray[size - 1] = 0;
		size--;
		return retValue;
	}

	public static void main(String[] args) {
		PriorityQueueImplementationUsingArray aq = new PriorityQueueImplementationUsingArray(5);
		aq.enqueue(0);
		aq.enqueue(1);
		aq.enqueue(2);
		aq.enqueue(3);
		aq.enqueue(4);

		System.out.println("Data at top of priority queue: " + aq.peek());
		System.out.println("Data removed from priority queue: " + aq.dequeue());

		aq.enqueue(5);

		System.out.println("Data at top of priority queue: " + aq.peek());
		System.out.println("Data removed from priority queue: " + aq.dequeue());

		System.out.println("Data at top of priority queue: " + aq.peek());
		System.out.println("Data removed from priority queue: " + aq.dequeue());

		System.out.println("Data at top of priority queue: " + aq.peek());
	}
}