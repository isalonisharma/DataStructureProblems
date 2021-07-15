package problems;

import java.util.Arrays;

public class CountOccurrencesOfAnagramsBruteForce {
	public static void main(String args[]) {
		String input = "aabaabaa";
		String pattern = "aaba";
		System.out.print(countAnagrams(input, pattern));
	}

	static int countAnagrams(String text, String pattern) {
		int patternWindowSize = pattern.length(), anagramCount = 0,
				lastPatternStartPosition = text.length() - patternWindowSize + 1;
		for (int i = 0; i < lastPatternStartPosition; i++) {
			String subString = text.substring(i, i + patternWindowSize);
			if (areAnagram(pattern, subString)) {
				anagramCount++;
			}
		}
		return anagramCount;
	}

	static boolean areAnagram(String pattern, String subString) {
		char[] patternCharArray = pattern.toCharArray();
		char[] subStringCharArray = subString.toCharArray();
		Arrays.sort(patternCharArray);
		Arrays.sort(subStringCharArray);
		return (Arrays.equals(patternCharArray, subStringCharArray)) ? true : false;
	}
}