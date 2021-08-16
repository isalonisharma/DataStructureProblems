package problems;

public class PrintSubset {
	public static void main(String args[]) {
		permutationFind("123", "");
	}

	private static void permutationFind(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}

		String includeOutput = output + input.charAt(0);
		input = input.substring(1);

		permutationFind(input, output);
		permutationFind(input, includeOutput);
	}
}