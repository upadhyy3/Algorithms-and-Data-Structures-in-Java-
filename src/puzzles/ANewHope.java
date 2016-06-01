package puzzles;

import java.util.Arrays;

public class ANewHope {

	public static int count(int[] previousWeek, int[] lastWeek, int d) {
		int length = previousWeek.length;
		int[] currentWeek;
		int index = -1;
		int count = 1;
		int element = -1;
		while (!Arrays.equals(previousWeek, lastWeek) && count < 10) {
			currentWeek = new int[length];
			for (int desiredIndex = 0; desiredIndex < previousWeek.length; desiredIndex++) {
				element = lastWeek[desiredIndex];
				index = findIndex(previousWeek, element);
				if (index + d >= length) { // (index + d) % length > 0) {
					// put on the best index
					int bestIndex = (index + d) % length;
					while (currentWeek[bestIndex] != 0) {
						bestIndex++;
					}
					currentWeek[bestIndex] = element;
				} else {
					// can be used on any day of the week
					if (currentWeek[desiredIndex] == 0) {
						currentWeek[desiredIndex] = element;
					} else {
						currentWeek[(index + d) % length] = element;
					}
				}
			}
			System.out.println(Arrays.toString(currentWeek));
			previousWeek = currentWeek;
			count++;
		}

		return count;
	}

	public static int findIndex(int[] currentWeek, int element) {
		for (int i = 0; i < currentWeek.length; i++) {
			if (currentWeek[i] == element) {
				return i;
			}
		}
		return 0;
	}

	public static int countNew(int[] firstWeek, int[] lastWeek, int D) {
		int n = firstWeek.length;
		int maxDelta = n - D, ans = 1;
		for (int x = 0; x < n; x++)
			for (int y = 0; y < x; y++)
				if (firstWeek[x] == lastWeek[y])
					ans = Math.max(ans, (x - y + maxDelta - 1) / maxDelta + 1);
		return ans;
	}

	public static void main(String[] args) {
		int[] firstWeek = { 1,2,3,4};
		int[] lastWeek = { 4,3,2,1};
		int d = 3;
		System.out.println(count(firstWeek, lastWeek, d));
		System.out.println(countNew(firstWeek, lastWeek, d));

	}
}

/*
 * public static ArrayList<ArrayList<Integer>> result = new
 * ArrayList<ArrayList<Integer>>(); public static int countOfVAlid = 0; public
 * static boolean breakRecursion = false; public static void nextPermute(int[]
 * firstWeek, int currentIndex, int[] permuteArray, int[] lastWeek) { if
 * (ANewHope.breakRecursion) { return; } else if (currentIndex ==
 * firstWeek.length) { if (Arrays.equals(permuteArray, lastWeek)) {
 * ANewHope.breakRecursion = true; }
 * System.out.println(Arrays.toString(permuteArray)); return; } for (int i =
 * currentIndex; i < firstWeek.length; i++) { swap(currentIndex, i, firstWeek);
 * permuteArray[currentIndex] = firstWeek[currentIndex]; nextPermute(firstWeek,
 * currentIndex + 1, permuteArray, lastWeek); swap(currentIndex, i, firstWeek);
 * } }
 * 
 * public static void swap(int source, int destination, int[] array) { int temp
 * = array[source]; array[source] = array[destination]; array[destination] =
 * temp; }
 */