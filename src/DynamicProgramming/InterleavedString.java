package DynamicProgramming;

public class InterleavedString {
	public boolean isInterleave(String s1, String s2, String s3) {

		if (s1.length() + s2.length() != s3.length())
			return false;
		int l1 = s1.length();
		int l2 = s2.length();
		boolean[][] DP = new boolean[l1 + 1][l2 + 1];

		// Null string is always the interleaving of two null strings

		DP[0][0] = true;
		for (int i = 1; i <= l1; i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
				DP[i][0] = DP[i - 1][0];
			}
		}

		for (int i = 1; i <= l2; i++) {
			if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
				DP[0][i] = DP[0][i - 1];
			}
		}

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {

				if (s2.charAt(j - 1) == s3.charAt(i + j - 1)
						&& s1.charAt(i - 1) != s3.charAt(i + j - 1)) {
					DP[i][j] = DP[i][j - 1];
				} else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)
						&& s2.charAt(j - 1) != s3.charAt(i + j - 1)) {
					DP[i][j] = DP[i - 1][j];
				} else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)
						&& s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					DP[i][j] = (DP[i - 1][j] || DP[i][j - 1]);
				}
			}
		}

		return DP[l1][l2];
	}

}
