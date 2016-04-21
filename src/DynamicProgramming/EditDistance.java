package DynamicProgramming;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null)
			return 0;
		else if (word1 == null && word2 != null)
			return word2.length();
		else if (word2 == null && word1 != null)
			return word1.length();

		int[][] DP = new int[word1.length() + 1][word2.length() + 1];

		DP[0][0] = 0;
		for (int i = 1; i <= word2.length(); i++) {
			DP[0][i] = i;
		}

		for (int j = 1; j <= word1.length(); j++) {
			DP[j][0] = j;
		}

		for (int i = 1; i < DP.length; i++) {
			for (int j = 1; j < DP[0].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					DP[i][j] = DP[i - 1][j - 1];
				} else {
					DP[i][j] = Math.min(DP[i - 1][j - 1],
							Math.min(DP[i - 1][j], DP[i][j - 1])) + 1;
				}
			}
		}

		return DP[word1.length()][word2.length()];
	}
}
