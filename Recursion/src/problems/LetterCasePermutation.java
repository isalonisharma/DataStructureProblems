package problems;

public class LetterCasePermutation {
	public static void main(String args[]) {
		String input = "a1B2", output = "";
		permutationFind(input, output);
	}

	private static void permutationFind(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}

		String current = String.valueOf(input.charAt(0));
		boolean isNumeric = Character.isDigit(input.charAt(0));

		if (isNumeric) {
			String numericIncludeOnly = output + current;
			input = input.substring(1);
			permutationFind(input, numericIncludeOnly);
		} else {
			String lowerOutput = output + current.toLowerCase();
			String upperOutput = output + current.toUpperCase();
			input = input.substring(1);

			permutationFind(input, lowerOutput);
			permutationFind(input, upperOutput);
		}
	}
}