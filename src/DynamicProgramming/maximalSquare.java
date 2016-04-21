package DynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class maximalSquare {

	// DFS solution
	int length;
	int breadth;

	class Coordinate {
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int maximalSquareCompute(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		length = matrix.length;
		breadth = matrix[0].length;
		int maxArea = 0;
		int area = 1;
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0')
					continue;
				area = findArea(i, j, matrix);
				if (area > maxArea)
					maxArea = area;
			}
		}

		return maxArea;
	}

	public int findArea(int i, int j, char[][] matrix) {
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		Coordinate newNode = new Coordinate(i, j);
		queue.add(newNode);
		int currentLength = 1;
		int currentBreadth = 1;
		int count;
		boolean flag = true;
		while (!queue.isEmpty()) {
			count = queue.size();
			flag = true;
			while (count != 0) {
				Coordinate temp = queue.poll();
				int x = temp.x;
				int y = temp.y;
				if (((x + 1) < length && matrix[x + 1][y] == '1')
						&& ((y + 1) < breadth && matrix[x][y + 1] == '1')
						&& ((y + 1) < breadth && (x + 1) < length && matrix[x + 1][y + 1] == '1')
						&& flag) {

					queue.add(new Coordinate(x + 1, y));
					queue.add(new Coordinate(x, y + 1));
					queue.add(new Coordinate(x + 1, y + 1));
				} else {
					flag = false;
					queue.clear();
					break;
				}
				count--;
			}
			if (flag) {
				currentLength++;
				currentBreadth++;
			}
		}

		return currentLength * currentBreadth;
	}
	
	//Dynamic Programming solution
	public int maximalSquareDP(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
	 
		int m = matrix.length;
		int n = matrix[0].length;
	 
		int[][] t = new int[m][n];
	 
		//top row
		for (int i = 0; i < m; i++) {
			t[i][0] = Character.getNumericValue(matrix[i][0]);
		}
	 
		//left column
		for (int j = 0; j < n; j++) {
			t[0][j] = Character.getNumericValue(matrix[0][j]);
		}
	 
		//cells inside
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					int min = Math.min(t[i - 1][j], t[i - 1][j - 1]);
					min = Math.min(min,t[i][j - 1]);
					t[i][j] = min + 1;
				} else {
					t[i][j] = 0;
				}
			}
		}
	 
		int max = 0;
		//get maximal length
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (t[i][j] > max) {
					max = t[i][j];
				}
			}
		}
	 
		return max * max;
	}
}
