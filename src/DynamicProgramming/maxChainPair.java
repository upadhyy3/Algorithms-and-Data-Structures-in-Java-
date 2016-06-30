package DynamicProgramming;

import java.util.*;

class pair {
	int start;
	int end;

	pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class maxChainPair {

	public static int maxLength(pair[] pairs) {
		int max = 0;
		Arrays.sort(pairs, new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}

		});

		int[] DP = new int[pairs.length];
		Arrays.fill(DP, 1);
		for (int i = 1; i < pairs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (pairs[j].end < pairs[i].start && DP[j] + 1 > DP[i]) {
					DP[i] = DP[j] + 1;
				}
			}

		}
		System.out.println(Arrays.toString(DP));
		for (int i = 0; i < DP.length; i++) {
			max = Math.max(DP[i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pair[] pairs = { new pair(5, 24), new pair(39, 60), new pair(15, 28),
				new pair(27, 40), new pair(50, 90) };
		System.out.println(maxLength(pairs));
	}
}
