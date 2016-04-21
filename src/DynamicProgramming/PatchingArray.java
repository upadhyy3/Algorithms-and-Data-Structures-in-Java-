package DynamicProgramming;

public class PatchingArray {

	public int minPatches(int[] nums, int n) {
		int count = 0, i = 0;
		for (long covered = 0; covered < n;) {
			if ((i < nums.length && nums[i] > covered + 1) || i >= nums.length) { 
				covered += covered + 1;
				++count;
			} else {
				covered += nums[i++];
			}
		}
		return count;
	}
}
