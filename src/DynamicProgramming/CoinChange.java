package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

	public static int coinChange(int[] coins, int amount) {
		int[][] DP = new int[coins.length][amount + 1];
		int include = 0;
		int exclude = 0;
		for (int k = 0; k < coins.length; k++) {
			DP[k][0] = 1;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {

				// include current coin
				if (j - coins[i] >= 0)
					include = DP[i][j - coins[i]];
				else
					include = 0;

				// exclude
				if (i >= 1)
					exclude = DP[i - 1][j];
				else
					exclude = 0;

				DP[i][j] = include + exclude;

			}
		}
		System.out.println(Arrays.deepToString(DP));
		return DP[coins.length - 1][amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {3,5,10};
		int amount = 13;
		System.out.println(coinChange(coins, amount));
	}

}
