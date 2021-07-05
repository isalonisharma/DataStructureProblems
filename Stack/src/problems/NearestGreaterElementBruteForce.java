package problems;

public class NearestGreaterElementBruteForce {
	static void printNGE(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int ge = -1;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					ge = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + ": " + ge);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
		printNGE(arr);
	}
}