package Arrays;
public class RemoveElement {

	public int removeElement(int[] nums, int val) {

		int indexToSwap = nums.length - 1;
		int currentLength = nums.length;
		for (int i = 0; i < currentLength; i++) {
			if (nums[i] == val) {
				while (indexToSwap >= i && nums[i] == val) {
					swap(nums, i, indexToSwap);
					indexToSwap--;
					currentLength--;
				}
			}
		}

		return currentLength;
	}

	public void swap(int[] nums, int current, int indexToSwap) {
		int temp = nums[current];
		nums[current] = nums[indexToSwap];
		nums[indexToSwap] = temp;
	}
}
