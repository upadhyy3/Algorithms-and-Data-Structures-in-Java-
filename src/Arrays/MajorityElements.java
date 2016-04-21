package Arrays;

public class MajorityElements {

    public int majorityElement(int[] nums) {
        int approximateElement = 0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(approximateElement == nums[i]){
                count++;
            }
            else if(count ==0){
                approximateElement = nums[i];
                count++;
            }
            else{
                count--;
            }
        }
        
        return approximateElement;
    }
}
