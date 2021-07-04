package problems;

import java.util.Stack;

public class NextSmallerElementUsingStack {
	public static void main(String args[]) {
		int arr[] = { 11, 9, 21, 3 };
		printNSE(arr);
	}

	private static void printNSE(int[] arr) {
		Stack<Integer> leftSide = new Stack<Integer>();
		leftSide.push(arr[0]);
		int size = arr.length;
		int current;
		for (int i = 1; i < size; i++) {
			current = arr[i];
			while (!leftSide.isEmpty() && leftSide.peek() > current) {
				System.out.println(leftSide.pop() + ": " + current);
			}
			leftSide.push(current);
		}

		while (!leftSide.isEmpty()) {
			System.out.println(leftSide.pop() + ": -1");
		}
	}
}
