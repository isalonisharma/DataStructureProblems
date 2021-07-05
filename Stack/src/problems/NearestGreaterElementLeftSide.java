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
		/*
		 * stack maintain left side elements. loop iterates from left to right.
		 */
		Stack<Integer> stack = new Stack<>();
		int[] output = new int[arr.length];
		int current;
		for (int i = 0; i < arr.length; i++) {
			current = arr[i];
			/* if stack is empty, then there is no left side elements so output -1 */
			if (stack.isEmpty()) {
				output[i] = -1;
			} else {
				/*
				 * popping till we find greater element & for next elements current will work as
				 * it is nearest greater one
				 */
				while (!stack.isEmpty() && current > stack.peek()) {
					stack.pop();
				}
				output[i] = (stack.empty()) ? (-1) : (stack.peek());
			}
			stack.push(current);
		}
		return output;
	}
}