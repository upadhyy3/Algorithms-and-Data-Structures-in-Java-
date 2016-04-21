package Arrays;

public class RotatedArray {

	public int findMin(int[] nums) {

		int pivot = findPivot(nums);
		if (pivot == -1) {
			return nums[0];
		}
		return nums[pivot];
	}

	public int findPivot(int a[]) {
		long low = 0;
		long high = a.length - 1;
		long n = a.length - 1;
		while (low <= high) {
			if (a[(int) low] <= a[(int) high]) {
				return (int) low;
			}
			long mid = low + (high - low) / 2;
			long prev = (mid - 1 + n) % n;
			long next = (mid + 1) % n;
			if (a[(int) mid] < a[(int) next] && a[(int) mid] < a[(int) prev]) {
				return (int) mid;
			} else if (a[(int) mid] <= a[(int) high]) {
				high = mid - 1;
			} else if (a[(int) mid] >= a[(int) low]) {
				low = mid + 1;
			}

		}
		return -1;
	}
}
