package problems;

import java.util.Stack;

public class NearestGreaterElementRightSide {
	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
		printNGE(arr);
	}

	/*
	 * leftSide is a stack. compare current element is greater than peek value, if
	 * it is than pop & print, it is not than do not go down because if peek is
	 * greater then lower value will already have their first next greatest element
	 */
	static void printNGE(int arr[]) {
		Stack<Integer> leftSide = new Stack<>();
		int size = arr.length;
		int current;
		for (int i = 0; i < size; i++) {
			current = arr[i];
			while (!leftSide.isEmpty() && leftSide.peek() < current) {
				System.out.println(leftSide.pop() + ": " + current);
			}
			leftSide.push(current);
		}

		while (!leftSide.isEmpty()) {
			System.out.println(leftSide.pop() + ": -1");
		}
	}
}