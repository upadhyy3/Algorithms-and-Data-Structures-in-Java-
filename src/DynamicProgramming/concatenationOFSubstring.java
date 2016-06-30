package DynamicProgramming;

import java.util.*;

public class concatenationOFSubstring {

	public static List<Integer> findSubString(String test, String[] dictionary) {
		List<Integer> result = new ArrayList<Integer>();
		int numberOfWords = dictionary.length;
		int patternLength = dictionary[0].length();
		int[][] lps = new int[numberOfWords][dictionary[0].length()];
		Map<Integer, ArrayList<String>> indexMap = new HashMap<Integer, ArrayList<String>>();
		computeLPS(dictionary, lps);

		for (int i = 0; i < dictionary.length; i++) {
			// System.out.println(findIndexes(test, dictionary[i], lps[i]));
			for (Integer index : findIndexes(test, dictionary[i], lps[i])) {
				if (indexMap.containsKey(index)) {
					ArrayList<String> temp = indexMap.get(index);
					temp.add(dictionary[i]);
					indexMap.put(index, temp);
				} else {
					ArrayList<String> temp = new ArrayList<String>();
					temp.add(dictionary[i]);
					indexMap.put(index, temp);
				}
			}
		}
		for (int currentIndex : indexMap.keySet()) {
			dfs(currentIndex, indexMap, patternLength, test.length(),
					numberOfWords, new HashSet<String>(), result);
		}
//		System.out.println(indexMap);
//		System.out.println(result);
		return result;
	}

	public static void dfs(int currentIndex,
			Map<Integer, ArrayList<String>> indexMap, int patternLength,
			int testLength, int numberOfWords, Set<String> set,
			List<Integer> result) {
		if (set.size() == numberOfWords) {
			result.add(currentIndex - (numberOfWords * patternLength));
			return;
		}
		if (!indexMap.containsKey(currentIndex)) {
			return;
		} else if (currentIndex >= testLength) {
			return;
		}
		for (String current : indexMap.get(currentIndex)) {
			set.add(current);
			dfs(currentIndex + patternLength, indexMap, patternLength,
					testLength, numberOfWords, set, result);
			set.remove(current);
		}
	}

	public static ArrayList<Integer> findIndexes(String test, String pattern,
			int[] lps) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		int i = 0, j = 0;
		while (i < test.length()) {
			if (test.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}

			if (j == pattern.length()) {
				indices.add(i - j);
				j = lps[j - 1];
			} else if (i < test.length() && test.charAt(i) != pattern.charAt(j)) {
				if (j > 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
		return indices;
	}

	public static void computeLPS(String[] pattern, int[][] lps) {

		for (int i = 0; i < pattern.length; i++) {
			char[] current = pattern[i].toCharArray();
			lps[i] = computeLPSUtil(current);
			// System.out.println(Arrays.toString(lps[i]));
		}
	}

	public static int[] computeLPSUtil(char[] array) {
		int[] lps = new int[array.length];
		lps[0] = 0;
		int len = 0;
		int index = 1;
		while (index < array.length) {
			if (array[len] == array[index]) {
				len++;
				lps[index] = len;
				index++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[index] = 0;
					index++;
				}
			}
		}
		return lps;
	}

	public static void main(String[] args) {
		String[] dictionary = { "foo", "bar" };
		String test = "barfoothefoobarman";
		System.out.println(findSubString(test, dictionary));
	}
}

/*
 * ArrayList<Integer> result = new ArrayList<Integer>(); ArrayList[] DP = new
 * ArrayList[test.length()+1]; DP[0] = new ArrayList<String>();
 * 
 * for(int i=0;i<test.length();i++){ if(DP[i] == null){ continue; }
 * 
 * for(String current:dictionary){ if(i+current.length()>= test.length()){
 * continue; }
 * 
 * if(current.equals(test.substring(i,i+current.length()))){ ArrayList<String>
 * temp = new ArrayList<String>(); temp.add(current); DP[i+current.length()] =
 * temp; } } } System.out.println(Arrays.toString(DP)); return result;
 */