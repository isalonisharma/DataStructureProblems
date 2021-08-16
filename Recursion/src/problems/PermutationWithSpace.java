package problems;

public class PermutationWithSpace {
	public static void main(String args[]) {
		String input = "ABC", output = "";
		output = String.valueOf(input.charAt(0));
		input = input.substring(1, input.length());
		permutationFind(input, output);
	}

	private static void permutationFind(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}

		String notIncludeOutput = output + input.charAt(0);
		String includeOutput = output + " " + input.charAt(0);
		input = input.substring(1);

		permutationFind(input, notIncludeOutput);
		permutationFind(input, includeOutput);
	}
}