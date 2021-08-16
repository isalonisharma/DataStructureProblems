package problems;

import java.util.Stack;

public class ReverseStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack = reverseStack(stack);
		stack.forEach(i -> System.out.println(i));
	}

	private static Stack<Integer> reverseStack(Stack<Integer> stack) {
		// base condition
		if (stack.isEmpty()) {
			return stack;
		}

		// hypothesis
		Integer topValue = stack.pop();
		stack = reverseStack(stack);

		// induction
		return insert(stack, topValue);
	}

	private static Stack<Integer> insert(Stack<Integer> stack, int temp) {
		// base condition
		if (stack.isEmpty()) {
			stack.push(temp);
			return stack;
		}

		// hypothesis
		int lastValue = stack.pop();
		stack = insert(stack, temp);

		// induction
		stack.push(lastValue);
		return stack;
	}
}