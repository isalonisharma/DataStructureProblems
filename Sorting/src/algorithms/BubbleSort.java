package algorithms;

public class BubbleSort {

	static void bubbleSort(int arr[]) {
		int temp;
		boolean swapAction;
		int length = arr.length;

		for (int k = 0; k < length - 1; k++) {

			swapAction = false;

			for (int i = 0; i < length - k - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					// swap arr[i] and arr[i+1]
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

					swapAction = true;
				}
			}

			if (swapAction == false) {
				break;
			}
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

		bubbleSort(input);

		System.out.print("\nSorted Array: ");
		printArray(input);
	}
}