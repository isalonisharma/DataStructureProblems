package problems;

import java.util.Stack;

public class NearestSmallerElementLeftSide {
	public static void main(String[] args) {
		int arr[] = { 11, 13, 3, 21 };
		int result[] = printNSE(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ": " + result[i]);
		}
	}

	private static int[] printNSE(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[arr.length];
		int current;
		for (int i = 0; i < arr.length; i++) {
			current = arr[i];
			while (!stack.isEmpty() && current < stack.peek()) {
				stack.pop();
			}
			result[i] = (stack.empty()) ? (-1) : (stack.peek());
			stack.push(current);
		}
		return result;
	}
}