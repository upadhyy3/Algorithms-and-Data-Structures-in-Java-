package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class climbingStairs {
	public int climbStairs(int n) {
		int[] DP = new int[n + 1];
		DP[0] = 1;
		DP[1] = 1;
		for (int i = 2; i <= n; i++) {
			DP[i] = DP[i - 1] + DP[i - 2];
		}
		return DP[n];
	}

	public Map<Integer, Integer> map;

	climbingStairs() {
		map = new HashMap<Integer, Integer>();
	}

	public int climbStairsDP(int n) {
		// if() return 0;
		if (n == 1 || n == 0)
			return 1;
		if (map.containsKey(n)) {
			return map.get(n);
		}
		int res = climbStairs(n - 1) + climbStairs(n - 2);
		map.put(n, res);
		return res;
	}

}
