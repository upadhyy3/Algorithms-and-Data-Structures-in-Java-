package Arrays;
import java.util.HashMap;


public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(nums.length <2) return result;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {   
                 
                 result[0] = map.get(nums[i]);
                 result[1] = i;
                 return result;
            }
            else
            {
                map.put(target-nums[i],i);
            }
        }
        
        return result;
    }
}
