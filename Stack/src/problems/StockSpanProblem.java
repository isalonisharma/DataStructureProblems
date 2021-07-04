package problems;

import java.util.Stack;

public class StockSpanProblem {
	static int[] calculateSpan(int input[]) {
		Stack<Integer> stack = new Stack<>();
		int output[] = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			while (!stack.empty() && input[stack.peek()] <= input[i]) {
				stack.pop();
			}
			output[i] = (stack.empty()) ? (i + 1) : (i - stack.peek());
			stack.push(i);
		}
		return output;
	}

	public static void main(String[] args) {
		int input[] = { 100, 80, 60, 70, 60, 75, 85 };
		int output[] = calculateSpan(input);
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i] + ": " + output[i]);
		}
	}
}