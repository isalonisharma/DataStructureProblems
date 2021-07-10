package problems;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementationUsingOneQueue {
	Queue<Integer> queue = new LinkedList<Integer>();

	void push(int data) {
		queue.add(data);
		for (int i = 0; i < queue.size(); i++) {
			int x = queue.remove();
			queue.add(x);
		}
	}

	int pop() {
		if (queue.isEmpty()) {
			System.out.println("No elements");
			return -1;
		} else {
			return queue.remove();
		}
	}

	int top() {
		if (queue.isEmpty()) {
			return -1;
		} else {
			return queue.peek();
		}
	}

	boolean isEmpty() {
		return queue.isEmpty();
	}

	public static void main(String[] args) {
		StackImplementationUsingOneQueue s = new StackImplementationUsingOneQueue();
		s.push(10);
		s.push(20);
		System.out.println("Top element :" + s.top());
		s.pop();
		s.push(30);
		System.out.println("Top element :" + s.top());
	}
}