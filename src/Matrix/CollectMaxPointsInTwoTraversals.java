package Matrix;

import java.util.*;

public class CollectMaxPointsInTwoTraversals {

	public static int maxValues(int[][] array) {
		int left = recursion(array, 0, 0, 0, array.length - 1, 0);
		int right = recursion(array, 0, 0, array[0].length - 1,
				array.length - 1, array[0].length - 1);
		System.out.println("left" + left);
		System.out.println("right" + right);
		return (left + right);
	}

	public static int recursion(int[][] array, int currentSum, int r, int c,
			int row, int col) {
		if (r == row && c == col) {
			currentSum += array[r][c];
			System.out.println(currentSum);
			return currentSum;
		} else if (r >= array.length || c >= array[0].length || r < 0 || c < 0)
			return 0;
		currentSum += array[r][c];
		currentSum = Math.max(recursion(array, currentSum, r + 1, c, row, col),
				Math.max(recursion(array, currentSum, r + 1, c + 1, row, col),
						recursion(array, currentSum, r + 1, c - 1, row, col)));

		return currentSum;
	}

	public static void main(String[] args) {
		int arr[][] = { { 3, 6, 8, 2 }, { 5, 2, 4, 3 }, { 1, 1, 20, 10 },
				{ 1, 1, 20, 10 }, { 1, 1, 20, 10 } };
		System.out.println(Arrays.deepToString(arr));
		System.out.println(maxValues(arr));
	}
}
