package problems;

import java.util.ArrayList;
import java.util.List;

public class MaximumOfEachSubarrayOfSizeKBruteForce {
	static List<Integer> maximumOfEachSubarrayOfSizeK(int integerArray[], int windowSize) {
		int maxValueInWindow = Integer.MIN_VALUE, lastSubArrayStartPosition = integerArray.length - windowSize + 1;
		List<Integer> maxValueList = new ArrayList<>();
		for (int i = 0; i < lastSubArrayStartPosition; i++) {
			maxValueInWindow = Integer.MIN_VALUE;
			for (int j = i; j < i + windowSize; j++) {
				maxValueInWindow = Math.max(maxValueInWindow, integerArray[j]);
			}
			maxValueList.add(maxValueInWindow);
		}
		return maxValueList;
	}

	public static void main(String[] args) {
		int integerArray[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int windowSize = 3;
		System.out.println(maximumOfEachSubarrayOfSizeK(integerArray, windowSize));
	}
}