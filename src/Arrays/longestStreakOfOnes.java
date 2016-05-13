package Arrays;

public class longestStreakOfOnes {

	public static int longestStreak(int[] arr, int k) {
		int maxLength = 0;
		int length = 0;
		int reserve = k;
		int[] DP = new int[arr.length];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			j = i;
			while (j < arr.length && (reserve > 0 || arr[j] == 1) ) {
				if (arr[j] == 0) {
					reserve--;
				}
				length++;
				j++;
			}
			maxLength = Math.max(maxLength, length);
			reserve = k;
			length =0;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0,0, 1, 1, 1, 0,
				1 };
		int k = 3;
		System.out.println(longestStreak(arr, k));

	}
}
