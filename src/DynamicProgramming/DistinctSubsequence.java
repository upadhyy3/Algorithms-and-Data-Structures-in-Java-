package DynamicProgramming;

public class DistinctSubsequence {
	public int numDistinct(String s, String t) {
		int[][] DP = new int[t.length() + 1][s.length() + 1];
		// null already matches with null
		DP[0][0] = 1;
		// converting a given string to null
		for (int j = 1; j <= s.length(); j++) {
			DP[0][j] = 1;
		}

		for (int i = 1; i <= t.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (t.charAt(i - 1) == s.charAt(j - 1)) {
					DP[i][j] += DP[i - 1][j - 1] + DP[i][j - 1];
					// flag = false;
				} else {
					DP[i][j] += DP[i][j - 1];
				}
			}
		}
		return DP[t.length()][s.length()];
	}
}
