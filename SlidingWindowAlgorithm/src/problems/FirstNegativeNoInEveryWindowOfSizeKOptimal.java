package problems;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNoInEveryWindowOfSizeKOptimal {
	static void firstNegativeInWindow(int integerArray[], int windowSize) {
		int start = 0, end = 0;
		Queue<Integer> negativeNo = new LinkedList<>();
		while (end < integerArray.length) {
			if (integerArray[end] < 0) {
				negativeNo.add(integerArray[end]);
			}
			if (end - start + 1 < windowSize) {
				end++;
			} else if (end - start + 1 == windowSize) {
				if (!negativeNo.isEmpty()) {
					System.out.print(negativeNo.peek() + " ");
				} else {
					System.out.print("0 ");
				}
				if (!negativeNo.isEmpty() && negativeNo.peek() == integerArray[start]) {
					negativeNo.remove();
				}
				start++;
				end++;
			}
		}
	}

	public static void main(String[] args) {
		int integerArray[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int windowSize = 3;
		firstNegativeInWindow(integerArray, windowSize);
	}
}