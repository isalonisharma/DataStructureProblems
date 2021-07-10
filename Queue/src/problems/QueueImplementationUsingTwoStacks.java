package problems;

import java.util.Stack;

class QueueStacks {
	Stack<Integer> enqueue = new Stack<>();
	Stack<Integer> dequeue = new Stack<>();
}

public class QueueImplementationUsingTwoStacks {
	static void push(Stack<Integer> stack, int new_data) {
		stack.push(new_data);
	}

	static int pop(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return stack.pop();
	}

	static void enQueue(QueueStacks q, int x) {
		push(q.enqueue, x);
	}

	static int deQueue(QueueStacks q) {
		int x;
		if (q.enqueue.isEmpty() && q.dequeue.isEmpty()) {
			System.out.println("Q is empty");
			return -1;
		}
		if (q.dequeue.isEmpty()) {
			while (!q.enqueue.isEmpty()) {
				x = pop(q.enqueue);
				push(q.dequeue, x);
			}
		}
		x = pop(q.dequeue);
		return x;
	}

	public static void main(String args[]) {
		QueueStacks q = new QueueStacks();
		enQueue(q, 1);
		enQueue(q, 2);
		enQueue(q, 3);
		System.out.print(deQueue(q) + " ");
		System.out.print(deQueue(q) + " ");
		System.out.println(deQueue(q) + " ");
	}
}