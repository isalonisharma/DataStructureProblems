package problems;

public class MaximumSumSubArrayOfSizeKBruteForce {
	static int maxSum(int integerArray[], int windowSize) {
		int maximumSum = Integer.MIN_VALUE, subArraySum = 0,
				lastSubArrayStartPosition = integerArray.length - windowSize + 1;
		for (int i = 0; i < lastSubArrayStartPosition; i++) {
			subArraySum = 0;
			for (int j = i; j < i + windowSize; j++) {
				subArraySum = subArraySum + integerArray[j];
			}
			maximumSum = Math.max(subArraySum, maximumSum);
		}
		return maximumSum;
	}

	public static void main(String[] args) {
		int integerArray[] = { 2, 3, 5, 2, 9, 7, 1 };
		int windowSize = 3;
		System.out.println(maxSum(integerArray, windowSize));
	}
}