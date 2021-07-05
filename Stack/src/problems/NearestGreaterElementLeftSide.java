package problems;

import java.util.Stack;

public class NearestGreaterElementLeftSide {
	public static void main(String[] args) {
		int arr[] = { 21, 3, 13, 11 };
		int output[] = printNGE(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ": " + output[i]);
		}
	}

	private static int[] printNGE(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] output = new int[arr.length];
		int current;
		for (int i = 0; i < arr.length; i++) {
			current = arr[i];
			/*
			 * popping till we find greater element & for next elements current will work as it
			 * is nearest one
			 */
			while (!stack.isEmpty() && current > stack.peek()) {
				stack.pop();
			}
			/* if stack is empty -1 or element found then save in result array */
			output[i] = (stack.empty()) ? (-1) : (stack.peek());
			stack.push(current);
		}
		return output;
	}
}