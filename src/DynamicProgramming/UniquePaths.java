package DynamicProgramming;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] DP = new int[m][n];

		DP[0][0] = 1;
		for (int i = 1; i < m; i++) {
			DP[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {
			DP[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				DP[i][j] = DP[i][j - 1] + DP[i - 1][j];
			}
		}

		return DP[m - 1][n - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] DP = new int[m][n];
		// DP[0][0] = 1;
		boolean indicator = true;
		for (int i = 0; i < m; i++) {
			if ((obstacleGrid[i][0] == 1) && indicator) {
				DP[i][0] = 0;
				indicator = false;
			} else if (!indicator) {
				DP[i][0] = 0;
			} else {
				DP[i][0] = 1;
			}
		}

		indicator = true;
		for (int i = 0; i < n; i++) {
			if ((obstacleGrid[0][i] == 1) && indicator) {
				DP[0][i] = 0;
				indicator = false;
			} else if (!indicator) {
				DP[0][i] = 0;
			} else {
				DP[0][i] = 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					DP[i][j] = 0;
				else
					DP[i][j] = DP[i][j - 1] + DP[i - 1][j];
			}
		}

		return DP[m - 1][n - 1];

	}
}
