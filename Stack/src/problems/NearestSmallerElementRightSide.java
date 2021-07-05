package problems;

import java.util.Stack;

public class NearestSmallerElementRightSide {
	public static void main(String args[]) {
		int arr[] = { 11, 9, 21, 3 };
		int output[] = printNSE(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ": " + output[i]);
		}
	}

	private static int[] printNSE(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] output = new int[arr.length];
		int current;
		for (int i = arr.length - 1; i >= 0; i--) {
			current = arr[i];
			if (stack.isEmpty()) {
				output[i] = -1;
			} else {
				while (!stack.isEmpty() && stack.peek() > current) {
					stack.pop();
				}
				output[i] = stack.isEmpty() ? -1 : stack.peek();
			}
			stack.push(current);
		}
		return output;
	}
}