package problems;

public class PetrolStationProblemOptimalApproach {
	public static void main(String[] args) {
		int[] petrolArray = { 1, 2, 3, 4, 5 };
		int[] distanceArray = { 3, 4, 5, 1, 2 };
		System.out.println(canCompleteCircuit(petrolArray, distanceArray));
	}

	private static int canCompleteCircuit(int[] petrolArray, int[] distanceArray) {
		int petrolStationCount = petrolArray.length;
		int surplus = 0, startingPetrolStation = 0, deficit = 0;
		for (int i = 0; i < petrolStationCount; i++) {
			surplus = surplus + petrolArray[i] - distanceArray[i];
			if (surplus < 0) {
				startingPetrolStation = i + 1;
				deficit += surplus;
				surplus = 0;
			}
		}
		return surplus + deficit >= 0 ? startingPetrolStation : -1;
	}
}