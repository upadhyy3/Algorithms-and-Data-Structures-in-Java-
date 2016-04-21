package Arrays;

public class MoveZeroes {
	
    public void moveZeroes(int[] nums) {
        
        int i=0; 
        int j=0;
        while(i<nums.length)
        {
            if(nums[i] == 0)
            {
                if(j==0) j=i;
                while(j<nums.length-1 && nums[j]==0)
                {
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
            i++;
        }
        
    }

}
