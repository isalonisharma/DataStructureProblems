package problems;

import java.util.Stack;

public class NearestGreaterElementRightSide {
	public static void main(String[] args) {
		int arr[] = { 11, 13, 3, 21 };
		int output[] = printNGR(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ": " + output[i]);
		}
	}

	private static int[] printNGR(int[] arr) {
		/*
		 * stack maintain right side elements. loop iterates from right to left.
		 */
		Stack<Integer> stack = new Stack<>();
		int[] output = new int[arr.length];
		int current;
		for (int i = arr.length - 1; i >= 0; i--) {
			current = arr[i];
			/* if stack is empty, then there is no right side elements so output -1 */
			if (stack.isEmpty()) {
				output[i] = -1;
			} else {
				/*
				 * if stack is not empty, then checking the element which is greater than
				 * current in stack as stack contains right side elements
				 */
				while (!stack.isEmpty() && stack.peek() < current) {
					/*
					 * popping the elements which are smaller as for new elements on left side
					 * current will be greater and it is closest
					 */
					stack.pop();
				}
				output[i] = stack.isEmpty() ? -1 : stack.peek();
			}
			stack.push(current);
		}
		return output;
	}
}