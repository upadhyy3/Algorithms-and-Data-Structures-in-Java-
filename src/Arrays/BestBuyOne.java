package Arrays;
public class BestBuyOne {

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0)
			return 0;
		int[] leftMin = new int[prices.length];
		int[] rightMax = new int[prices.length];

		leftMin[0] = prices[0];
		for (int i = 1; i < prices.length; i++) {
			leftMin[i] = Math.min(prices[i], leftMin[i - 1]);
		}

		rightMax[rightMax.length - 1] = prices[rightMax.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(prices[i], rightMax[i + 1]);
		}

		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			maxProfit = Math.max(rightMax[i] - leftMin[i], maxProfit);
		}

		return maxProfit;
	}
}
