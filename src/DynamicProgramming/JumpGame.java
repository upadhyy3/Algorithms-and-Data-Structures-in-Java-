package DynamicProgramming;

public class JumpGame {

	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		// int head = 0;
		int tail = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (tail >= nums.length - 1)
				return true;

			if (tail <= i && nums[i] == 0)
				return false;
			tail = Math.max(i + nums[i], tail);

		}

		return false;
	}
	
    public static int jump(int[] nums) {
            if(nums.length == 0 || nums.length == 1) return 0;
            int head =0;
            int tail = nums[0];
            int temp;
            int minJump = 1;
            
            while(tail < nums.length-1 )
            {
                temp = tail;
                for(int i=head;i<=temp;i++)
                {
                    tail = Integer.max(tail,i+nums[i]);
                }
                
                head = temp+1;
                minJump++;
            }
            
            return minJump;
    }
    
    
    public static void main(String[] args){
    	int[] nums = {1,1,1,1,1};
    	System.out.println(jump(nums));
    }
}
