package problems;

import java.util.Stack;

public class SortStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(0);
		stack.push(5);
		stack.push(2);
		stack = sort(stack);
		stack.forEach(i -> System.out.println(i));
	}

	private static Stack<Integer> sort(Stack<Integer> stack) {
		// base condition
		if (stack.size() == 1) {
			return stack;
		}

		// hypothesis
		Integer lastValue = stack.pop();
		stack = sort(stack);

		// induction
		return insert(stack, lastValue);
	}

	private static Stack<Integer> insert(Stack<Integer> stack, int temp) {
		// base condition
		if (stack.isEmpty() || temp >= stack.peek()) {
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