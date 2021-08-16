package problems;

public class TowerOfHanoi {
	static void towerOfHanoi(int n, char source, char destination, char helper) {
		if (n == 1) {
			System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
			return;
		}
		towerOfHanoi(n - 1, source, helper, destination);
		System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);
		towerOfHanoi(n - 1, helper, destination, source);
	}

	public static void main(String args[]) {
		towerOfHanoi(3, 'S', 'D', 'H');
	}
}