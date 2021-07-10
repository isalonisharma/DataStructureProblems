package problems;

import java.util.*;

public class StackImplementationUsingTwoQueues {
	Queue<Integer> queueStack = new LinkedList<>(), tempQueue = new LinkedList<>();
	int size;

	public StackImplementationUsingTwoQueues() {
		size = 0;
	}

	void push(int x) {
		queueStack.add(x);
		size++;
	}

	int pop() {
		if (queueStack.isEmpty()) {
			return -1;
		} else {
			while (queueStack.size() != 1) {
				tempQueue.add(queueStack.peek());
				queueStack.remove();
			}

			int temp = queueStack.remove();
			size--;

			Queue<Integer> q = queueStack;
			queueStack = tempQueue;
			tempQueue = q;
			return temp;
		}
	}

	int top() {
		if (queueStack.isEmpty()) {
			return -1;
		} else {
			while (queueStack.size() != 1) {
				tempQueue.add(queueStack.peek());
				queueStack.remove();
			}

			int temp = queueStack.peek();
			queueStack.remove();
			tempQueue.add(temp);

			Queue<Integer> q = queueStack;
			queueStack = tempQueue;
			tempQueue = q;
			return temp;
		}
	}

	int size() {
		return size;
	}
	
	void show() {
		System.out.print("Stack: ");
		for(int i = queueStack.size(); i > 0; i--) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		StackImplementationUsingTwoQueues s = new StackImplementationUsingTwoQueues();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.show();
		System.out.println("\nsize: " + s.size());
		System.out.println("top: " + s.top());
		System.out.println("popped value: " + s.pop());
		System.out.println("popped value: " + s.pop());
		s.show();
		System.out.println("\nsize: " + s.size());
	}
}