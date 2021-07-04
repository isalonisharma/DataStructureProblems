package problems;

import java.util.Stack;

public class SortStackWithRecursion {
	static Stack<Integer> stack = new Stack<>();

	static void sort() {
		/* remember this is a if condition if(!st.isEmpty()) */
		if (!stack.isEmpty()) {
			int popped = stack.pop();
			sort();
			insertAtBottom(popped);
		}
	}

	private static void insertAtBottom(int bottom) {
		if (stack.isEmpty()) {
			stack.push(bottom);
		} else {
			int peek = stack.peek();
			if (bottom < peek) {
				int popped = stack.pop();
				insertAtBottom(bottom);
				stack.push(popped);
			} else {
				stack.push(bottom);
			}
		}
	}

	public static void main(String[] args) {
		stack.push(30);
		stack.push(-5);
		stack.push(18);
		stack.push(14);
		stack.push(-3);
		System.out.println("stack: " + stack);
		sort();
		System.out.println("sorted stack: " + stack);
	}
}