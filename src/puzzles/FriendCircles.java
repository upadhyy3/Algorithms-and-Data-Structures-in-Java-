package puzzles;

public class FriendCircles {

	public static int getFriendCircleCount(boolean[][] friends) {
		boolean[] visited = new boolean[friends.length];
		int circleCount = 0;
		for (int i = 0; i < friends.length; i++) {
			if (!visited[i]) {
				circleCount++;
				visited[i] = true;
				getFriendCircleCount(friends, visited, i);
			}

		}
		return circleCount;
	}

	public static void getFriendCircleCount(boolean[][] friends,
			boolean[] visited, int element) {

//
//		visited[i][j] = true;
//		boolean flag = false;
		for (int col = 0; col < friends.length; col++) {
			if (friends[element][col] && element != col && !visited[col]) {
				getFriendCircleCount(friends, visited, col);
			}

		}
	}

	public static void main(String[] args) {
		boolean[][] friendsOne = { { true, true, false, false },
				{ true, true, true, false }, { false, true, true, false },
				{ false, false, false, true } };

		/*
		 * YNNNN NYNNN NNYNN NNNYN NNNNY
		 */
		boolean[][] friendsTwo = { { true, false, false, false, false },
				{ false, true, false, false, false },
				{ false, false, true, false, false },
				{ false, false, false, true, false },
				{ false, false, false, false, true } };
		System.out.println(getFriendCircleCount(friendsOne));
	}
}
