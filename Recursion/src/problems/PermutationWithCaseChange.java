package problems;

public class PermutationWithCaseChange {
	public static void main(String args[]) {
		String input = "ab", output = "";
		permutationFind(input, output);
	}

	private static void permutationFind(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}

		String notIncludeOutput = output + String.valueOf(input.charAt(0));
		String includeOutput = output + String.valueOf(input.charAt(0)).toUpperCase();
		input = input.substring(1);

		permutationFind(input, notIncludeOutput);
		permutationFind(input, includeOutput);
	}
}