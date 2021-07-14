package problems;

public class FirstNegativeNoInEveryWindowOfSizeKBruteForce {
	static void firstNegativeInWindow(int integerArray[], int windowSize) {
		int lastSubArrayStartPosition = integerArray.length - windowSize + 1;
		boolean negativeNoFound = false;
		for (int i = 0; i < lastSubArrayStartPosition; i++) {
			negativeNoFound = false;
			for (int j = i; j < i + windowSize; j++) {
				if (integerArray[j] < 0) {
					negativeNoFound = true;
					System.out.print(integerArray[j] + " ");
					break;
				}
			}
			if (!negativeNoFound) {
				System.out.print("0 ");
			}
		}
	}

	public static void main(String[] args) {
		int integerArray[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int windowSize = 3;
		firstNegativeInWindow(integerArray, windowSize);
	}
}