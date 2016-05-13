package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeletionOfWordToMatchInDictionary {

	public static int editDistance(String s, Set<String> dictionary) {
		int minEditDistance = Integer.MAX_VALUE;
		for (String current : dictionary) {
			minEditDistance = Math.min(minEditDistance, helperEdit(s, current));
		}
		return minEditDistance;
	}

	public static int helperEdit(String s1, String s2) {
		int[][] DP = new int[s1.length() + 1][s2.length() + 1];
		DP[0][0] = 0;
		int len1 = s1.length();
		int len2 = s2.length();
		for (int i = 1; i <= len1; i++) {
			DP[i][0] = i;
		}
		for (int j = 1; j <= len2; j++) {
			DP[0][j] = j;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
					DP[i][j] = Math.min(DP[i - 1][j - 1],
							(Math.min(DP[i][j - 1], DP[i - 1][j]))) + 1;
				} else {
					DP[i][j] = DP[i - 1][j - 1];
				}
			}
		}
		return DP[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		String[] dictionary = { "cat", "dog", "shivam" };
		Set<String> dic = new HashSet<String>(Arrays.asList(dictionary));
		System.out.println(editDistance("boy", dic));
	}
}
