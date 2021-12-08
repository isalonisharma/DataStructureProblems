package algorithms;

public class QuickSort {

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int smallIndex = (start - 1);
		
		for (int loopVariable = start; loopVariable <= end - 1; loopVariable++) {
			
			if (arr[loopVariable] < pivot) {
				smallIndex++;
				swap(arr, loopVariable, smallIndex);
			}
			
		}
		
		swap(arr, smallIndex + 1, end);
		
		return (smallIndex + 1);
	}

	static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			/* pIndex is partitioning index, arr[pIndex] is now at right place */
			int pIndex = partition(arr, start, end);

			/* Separately sort elements before partition and after partition */
			quickSort(arr, start, pIndex - 1);
			quickSort(arr, pIndex + 1, end);
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

		quickSort(input, 0, input.length - 1);

		System.out.print("\nSorted Array: ");
		printArray(input);
	}
}