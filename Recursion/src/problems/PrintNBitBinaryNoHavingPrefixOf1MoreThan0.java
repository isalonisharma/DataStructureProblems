package problems;

import java.util.ArrayList;
import java.util.List;

public class PrintNBitBinaryNoHavingPrefixOf1MoreThan0 {
	
	public static void main(String args[]) {
		int input = 3;
		List<String> output = new ArrayList<>();
		permutationFind(input, 0, 0, "", output);
		output.forEach(i -> System.out.println(i));
	}

	private static void permutationFind(int input, int one, int zero, String binaryResult, List<String> output) {
		if (input == 0) {
			output.add(binaryResult);
			return;
		} else {
			String oneIncluded = binaryResult + "1";
			permutationFind(input - 1, one + 1, zero, oneIncluded, output);

			if (one > zero) {
				String zeroIncluded = binaryResult + "0";
				permutationFind(input - 1, one, zero + 1, zeroIncluded, output);
			}
		}
	}
}