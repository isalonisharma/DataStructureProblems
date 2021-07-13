package problems;

public class MaximumSumSubArrayOfSizeKOptimal {
	static int maxSum(int integerArray[], int windowSize) {
		int maximumSum = Integer.MIN_VALUE, subArraySum = 0, start = 0, end = 0;
		while (end < integerArray.length) {
			subArraySum += integerArray[end];
			if (end - start + 1 < windowSize) {
				end++;
			} else if (end - start + 1 == windowSize) {
				maximumSum = Math.max(subArraySum, maximumSum);
				subArraySum -= integerArray[start];
				start++;
				end++;
			}
		}
		return maximumSum;
	}

	public static void main(String[] args) {
		int integerArray[] = { 2, 3, 5, 2, 9, 7, 1 };
		int windowSize = 3;
		System.out.println(maxSum(integerArray, windowSize));
	}
}