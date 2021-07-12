package problems;

public class PetrolStationProblemBruteForceApproach {
	public static void main(String[] args) {
		int[] petrolArray = { 1, 2, 3, 4, 5 };
		int[] distanceArray = { 3, 4, 5, 1, 2 };
		System.out.println(canCompleteCircuit(petrolArray, distanceArray));
	}

	static int canCompleteCircuit(int[] petrolArray, int[] distanceArray) {
		int petrolStationCount = petrolArray.length, petrolBalance = 0;
		boolean isCircuitComplete = true;

		for (int i = 0; i < petrolStationCount; i++) {
			petrolBalance = petrolArray[i];
			isCircuitComplete = true;

			for (int j = 0; j < petrolStationCount; j++) {
				int currentStation = (i + j) % petrolStationCount;
				petrolBalance = petrolBalance - distanceArray[currentStation];

				if (petrolBalance < 0) {
					isCircuitComplete = false;
					break;
				}

				int nextStation = (currentStation + 1) % petrolStationCount;
				petrolBalance = petrolBalance + petrolArray[nextStation];
			}

			if (isCircuitComplete) {
				return i;
			}
		}
		return -1;
	}
}