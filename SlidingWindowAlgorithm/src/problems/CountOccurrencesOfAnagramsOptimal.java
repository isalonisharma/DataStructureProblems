package problems;

import java.util.HashMap;

public class CountOccurrencesOfAnagramsOptimal {
	public static void main(String[] args) {
		String input = "aabaabaa";
		String pattern = "aaba";
		System.out.println(countOccurrencesOfAnagrams(input, pattern));
	}

	public static int countOccurrencesOfAnagrams(String input, String pattern) {
		HashMap<Character, Integer> patternCharCountMap = new HashMap<>();
		int i = 0, patternDistinctCharCount = 0, patternLength = pattern.length();
		int start = 0, end = 0, anagramCount = 0;

		while (i < patternLength) {
			char patternChar = pattern.charAt(i);
			if (!patternCharCountMap.containsKey(patternChar)) {
				patternCharCountMap.put(patternChar, 1);
			} else {
				patternCharCountMap.put(patternChar, patternCharCountMap.get(patternChar) + 1);
			}
			i++;
		}
		patternDistinctCharCount = patternCharCountMap.size();

		while (end < input.length()) {
			char inputChar = input.charAt(end);
			if (patternCharCountMap.containsKey(inputChar)) {
				patternCharCountMap.put(inputChar, patternCharCountMap.get(inputChar) - 1);
				if (patternCharCountMap.get(inputChar) == 0) {
					patternDistinctCharCount--;
				}
			}

			if (end - start + 1 < patternLength) {
				end++;
			} else if (end - start + 1 == patternLength) {
				if (patternDistinctCharCount == 0) {
					anagramCount++;
				}
				char previousWindowChar = input.charAt(start);
				if (patternCharCountMap.containsKey(previousWindowChar)) {
					patternCharCountMap.put(previousWindowChar, patternCharCountMap.get(previousWindowChar) + 1);
					if (patternCharCountMap.get(previousWindowChar) == 1) {
						patternDistinctCharCount++;
					}
				}
				start++;
				end++;
			}

		}
		return anagramCount;
	}
}