package problems;

import java.util.Stack;

public class NearestSmallerElementLeftSide {
	public static void main(String[] args) {
		int arr[] = { 11, 13, 3, 21 };
		int output[] = printNSE(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ": " + output[i]);
		}
	}

	private static int[] printNSE(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] output = new int[arr.length];
		int current;
		for (int i = 0; i < arr.length; i++) {
			current = arr[i];
			if (stack.isEmpty()) {
				output[i] = -1;
			} else {
				while (!stack.isEmpty() && current < stack.peek()) {
					stack.pop();
				}
				output[i] = (stack.empty()) ? (-1) : (stack.peek());
			}
			stack.push(current);
		}
		return output;
	}
}