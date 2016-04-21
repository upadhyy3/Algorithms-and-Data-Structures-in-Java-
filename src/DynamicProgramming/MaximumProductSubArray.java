package DynamicProgramming;

public class MaximumProductSubArray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int currentPos = 1;
		int currentNeg = 1;
		int maxPos = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				currentPos = currentPos * nums[i];
				if (currentNeg != 1)
					currentNeg = currentNeg * nums[i];
			} else if (nums[i] < 0) {
				if (currentNeg == 1) {
					currentNeg = currentPos * nums[i];
					currentPos = 1;
					continue;
				} else {
					int temp = currentNeg;
					currentNeg = currentPos * nums[i];
					currentPos = temp * nums[i];
				}
			} else {
				currentPos = 1;
				currentNeg = 1;
				continue;
			}

			if (currentPos > maxPos)
				maxPos = currentPos;
		}

		return maxPos;
	}
}
