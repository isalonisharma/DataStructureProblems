package algorithms;

public class SelectionSort {

	static void selectionSort(int arr[]) {
		int length = arr.length;

		for (int i = 0; i < length - 2; i++) {

			int ithMinimum = i;
			for (int j = i + 1; j < length; j++) {
				if (arr[j] < arr[ithMinimum]) {
					ithMinimum = j;
				}
			}

			int temp = arr[ithMinimum];
			arr[ithMinimum] = arr[i];
			arr[i] = temp;
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

		selectionSort(input);

		System.out.print("\nSorted Array: ");
		printArray(input);
	}
}