package algorithms;

class MergeSort {
	static void merge(int arr[], int l, int middlePoint, int r) {
		int leftLength = middlePoint - l + 1;
		int rightLength = r - middlePoint;

		int leftArray[] = new int[leftLength];
		int rightArray[] = new int[rightLength];

		for (int i = 0; i < leftLength; ++i) {
			leftArray[i] = arr[l + i];
		}
			
		for (int i = 0; i < rightLength; ++i) {
			rightArray[i] = arr[middlePoint + 1 + i];
		}

		/* Merge the temp arrays */

		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < leftLength && j < rightLength) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < leftLength) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < rightLength) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int middlePoint = l + (r - l) / 2;

			// Sort first and second halves
			mergeSort(arr, l, middlePoint);
			mergeSort(arr, middlePoint + 1, r);

			// Merge the sorted halves
			merge(arr, l, middlePoint, r);
		}
	}

	static void printArray(int input[]) {
		int length = input.length;
		for (int i = 0; i < length; i++) {
			System.out.print(input[i] + " ");
		}
	}

	public static void main(String args[]) {
		int input[] = { 2, 7, 4, 1, 5, 3 };

		System.out.print("Un-Sorted Array: ");
		printArray(input);

		mergeSort(input, 0, input.length - 1);

		System.out.print("\nSorted Array: ");
		printArray(input);
	}
}