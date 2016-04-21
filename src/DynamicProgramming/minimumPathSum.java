package DynamicProgramming;

public class minimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		if (m == 0 && n == 0)
			return 0;

		int[][] DP = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					DP[0][0] = grid[0][0];
				} else if (i == 0 & j > 0) {
					DP[i][j] = DP[i][j - 1] + grid[i][j];
				} else if (j == 0 && i > 0) {
					DP[i][j] = DP[i - 1][j] + grid[i][j];
				} else if (i > 0 && j > 0) {
					DP[i][j] = Math.min(DP[i - 1][j], DP[i][j - 1])
							+ grid[i][j];
				}
			}
		}

		return DP[m - 1][n - 1];
	}

}
