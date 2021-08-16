package problems;

import java.util.Stack;

public class DeleteMiddleElementOfStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		int middlePosition = (stack.size() / 2) + 1;
		stack = deleteMiddleElementOfStack(stack, middlePosition);
		stack.forEach(i -> System.out.println(i));
	}

	private static Stack<Integer> deleteMiddleElementOfStack(Stack<Integer> stack, int middlePosition) {
		if (stack.isEmpty()) {
			return stack;
		}

		// base condition
		if (middlePosition == 1) {
			stack.pop();
			return stack;
		}

		// hypothesis
		Integer lastValue = stack.pop();
		stack = deleteMiddleElementOfStack(stack, --middlePosition);

		// induction
		stack.push(lastValue);

		return stack;
	}
}