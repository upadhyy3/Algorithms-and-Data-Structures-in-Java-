package puzzles;

import java.util.Arrays;
import java.util.Scanner;

public class DivisibleSumPairs {

	public static int computeNoOfPairs(int[] array, int k) {
		int result = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (i == j)
					continue;
				if ((array[i] + array[j]) % k == 0) {
					result++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		System.out.println(computeNoOfPairs(a, k));
		in.close();
	}
}
