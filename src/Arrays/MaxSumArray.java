package Arrays;

public class MaxSumArray {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] DP = new int[len];
        DP[0] = nums[0];
        int maxSum = DP[0];
        for(int i=1;i<len;i++){
            DP[i] = Math.max(nums[i],DP[i-1] + nums[i]);
            if(DP[i] > maxSum){
                maxSum = DP[i];
            }
        }
        
        return maxSum;
    }
}
