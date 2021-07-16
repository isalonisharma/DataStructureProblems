package problems;

import java.util.ArrayList;

public class MaximumOfEachSubarrayOfSizeKOptimal {
	static ArrayList<Integer> maximumOfEachSubarrayOfSizeK(int integerArray[], int windowSize) {
		if (windowSize <= 0 || integerArray == null || integerArray.length == 0) {
			return new ArrayList<>();
		}

		ArrayList<Integer> windowMaxList = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		int start = 0, end = 0;
		

		while (end < integerArray.length) {
			while (!temp.isEmpty() && temp.get(temp.size() - 1) <= integerArray[end]) {
				temp.remove(temp.size() - 1);
			}
			temp.add(integerArray[end]);

			if (end - start + 1 < windowSize) {
				end++;
			} else if (end - start + 1 == windowSize) {
				windowMaxList.add(temp.get(0));
				if (!temp.isEmpty() && temp.get(0) == integerArray[start]) {
					temp.remove(0);
				}
				end++;
				start++;
			}
		}
		return windowMaxList;
	}

	public static void main(String[] args) {
		int integerArray[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int windowSize = 3;
		System.out.println(maximumOfEachSubarrayOfSizeK(integerArray, windowSize));
	}
}