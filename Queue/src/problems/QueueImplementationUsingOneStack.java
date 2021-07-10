package problems;

import java.util.Stack;

class QueueStack {
	Stack<Integer> queueStack;
}

public class QueueImplementationUsingOneStack {
	static void push(Stack<Integer> stack, int data) {
		stack.push(data);
	}

	static int pop(Stack<Integer> stack) {
		if (stack == null) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return stack.pop();
	}

	static void enQueue(QueueStack q, int x) {
		push(q.queueStack, x);
	}

	static int deQueue(QueueStack q) {
		int x, res = 0;
		if (q.queueStack.isEmpty()) {
			System.out.println("Q is Empty");
			return -1;
		} else if (q.queueStack.size() == 1) {
			return pop(q.queueStack);
		} else {
			x = pop(q.queueStack);
			res = deQueue(q);
			push(q.queueStack, x);
			return res;
		}
	}

	public static void main(String[] args) {
		QueueStack q = new QueueStack();
		q.queueStack = new Stack<>();
		enQueue(q, 1);
		enQueue(q, 2);
		enQueue(q, 3);
		System.out.print(deQueue(q) + " ");
		System.out.print(deQueue(q) + " ");
		System.out.print(deQueue(q) + " ");
	}
}