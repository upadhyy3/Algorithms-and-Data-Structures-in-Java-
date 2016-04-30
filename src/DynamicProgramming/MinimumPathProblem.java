package DynamicProgramming;

import java.util.*;

public class MinimumPathProblem {

	public static int findMinimumPath(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] DP = new int[row][col];
		DP[0][0] = matrix[0][0];
		for (int i = 1; i < row; i++) {
			DP[i][0] += DP[i - 1][0] + matrix[i][0];
		}

		for (int i = 1; i < col; i++) {
			DP[0][i] += DP[0][i - 1] + matrix[0][i];
		}

		System.out.println(Arrays.deepToString(DP));
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				DP[i][j] += Math.min(DP[i - 1][j - 1],
						Math.min(DP[i - 1][j], DP[i][j - 1]))
						+ matrix[i][j];
			}
		}
		return DP[row - 1][col - 1];
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 8;
		matrix[1][2] = 2;
		matrix[2][0] = 1;
		matrix[2][1] = 5;
		matrix[2][2] = 3;
		System.out.println(Arrays.deepToString(matrix));
		System.out.println(findMinimumPath(matrix));
	}
}
