package Graph;

public class ShortestPathInBinaryMaze {

	static int result = Integer.MAX_VALUE;

	public static int findShortestPath(int[][] mat, int[] source, int[] dest) {
		boolean[][] visisted = new boolean[mat.length][mat[0].length];
		bfs(mat, source[0], source[1], dest, new Integer(1), visisted);
		return result;
	}

	public static void bfs(int[][] mat, int x, int y, int[] dest,
			Integer currentLength, boolean[][] visited) {
		if (dest[0] == x && dest[1] == y) {
			if (result > currentLength.intValue()) {
				System.out.println("Cam here");
				result = currentLength;
			}
			return;
		} else if (dest[0] < x || dest[1] < y || y < 0 || x < 0
				|| x > mat.length || y > mat[0].length || visited[x][y]
				|| mat[x][y] == 0) {
			return;
		}
		currentLength++;
		visited[x][y] = true;
		bfs(mat, x - 1, y - 1, dest, currentLength, visited);
		bfs(mat, x - 1, y, dest, currentLength, visited);
		bfs(mat, x - 1, y + 1, dest, currentLength, visited);
		bfs(mat, x, y - 1, dest, currentLength, visited);
		bfs(mat, x, y + 1, dest, currentLength, visited);
		bfs(mat, x + 1, y - 1, dest, currentLength, visited);
		bfs(mat, x + 1, y, dest, currentLength, visited);
		bfs(mat, x + 1, y + 1, dest, currentLength, visited);
		currentLength--;
		return;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

		int[][] matTest = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 } };
		int[] source = { 0, 0 };
		int[] dest = { 3, 4 };
		System.out.println(findShortestPath(mat, source, dest));

	}
}
