package Arrays;

public class TrapWater {

	public int trap(int[] height) {
		if (height.length == 0 || height.length == 1)
			return 0;
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		int volume = 0;
		leftMax[0] = height[0];
		for (int i = 1; i < leftMax.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}
		rightMax[rightMax.length - 1] = height[height.length - 1];
		for (int i = rightMax.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		for (int i = 0; i < height.length; i++) {
			volume += Math.min(leftMax[i], rightMax[i]) - height[i];
		}

		return volume;

	}
}
