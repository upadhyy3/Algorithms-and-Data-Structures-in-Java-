package Graph;

import java.util.ArrayList;

public class Boggle {

	public static ArrayList<String> result;

	public static ArrayList<String> findWords(String[] dictionary,
			char[][] boggle) {
		result = new ArrayList<String>();
		boolean[][] visited;
		for (String current : dictionary) {
			visited = new boolean[boggle.length][boggle[0].length];
			for (int row = 0; row < boggle.length; row++) {
				for (int col = 0; col < boggle[0].length; col++) {
					if (isWord(current, boggle, row, col, 0, visited)) {
						result.add(current);
						break;
					}
				}
			}

		}
		return result;

	}

	public static boolean isWord(String current, char[][] boggle, int row,
			int col, int currentIndex, boolean[][] visited) {
		if (currentIndex == current.length()) {
			return true;
		} else if (row < 0 || col < 0 || row >= boggle.length
				|| col >= boggle[0].length || visited[row][col]) {
			return false;
		} else if (boggle[row][col] == current.charAt(currentIndex)) {
			visited[row][col] = true;
			System.out.println(current.substring(0, currentIndex));
			if (isWord(current, boggle, row - 1, col, currentIndex + 1, visited)
					|| isWord(current, boggle, row - 1, col - 1,
							currentIndex + 1, visited)
					|| isWord(current, boggle, row - 1, col + 1,
							currentIndex + 1, visited)
					|| isWord(current, boggle, row, col - 1, currentIndex + 1,
							visited)
					|| isWord(current, boggle, row, col + 1, currentIndex + 1,
							visited)
					|| isWord(current, boggle, row + 1, col - 1,
							currentIndex + 1, visited)
					|| isWord(current, boggle, row + 1, col, currentIndex + 1,
							visited)
					|| isWord(current, boggle, row + 1, col + 1,
							currentIndex + 1, visited)) {

				return true;
			} else {

				return false;
			}
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		char boggle[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' },
				{ 'Q', 'S', 'E' } };
		String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GO" };
		System.out.println(findWords(dictionary, boggle).toString());
	}
}
