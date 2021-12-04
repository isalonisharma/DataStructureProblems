package algorithms;

public class InsertionSort {

	static void insertionSort(int arr[]) {

		int length = arr.length;

		for (int i = 1; i < length; i++) {

			int value = arr[i];
			int hole = i;

			while (hole > 0 && arr[hole - 1] > value) {
				arr[hole] = arr[hole - 1];
				hole = hole - 1;
			}

			arr[hole] = value;
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

		insertionSort(input);

		System.out.print("\nSorted Array: ");
		printArray(input);
	}
}