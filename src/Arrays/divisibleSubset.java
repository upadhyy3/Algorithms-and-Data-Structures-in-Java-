package Arrays;

import java.util.*;

public class divisibleSubset {
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
	    List<Integer> res = new ArrayList<Integer>();
	    if(nums.length == 0)    return res;
	    Arrays.sort(nums);
	    int maxSize = Integer.MAX_VALUE;
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    for(int i = 0; i < nums.length; i++) {
	        int max = 0;
	        for(int j = 0; j < i; j++) {
	            if(nums[i] % nums[j] != 0) continue;
	            if(map.get(nums[j]).size() > max) {
	                List<Integer> tmp = new ArrayList<>(map.get(nums[j]));
	                max = tmp.size();
	                tmp.add(nums[i]);
	                map.put(nums[i], tmp);
	            }
	        }
	        if(!map.containsKey(nums[i])) {
	            List<Integer> t1 = new ArrayList<Integer>();
	            t1.add(nums[i]);
	            map.put(nums[i], t1);
	        }
	        if(!map.containsKey(maxSize) || map.get(maxSize).size() < map.get(nums[i]).size()) {
	            maxSize = nums[i];
	        } 
	    }
	    return map.get(maxSize);
	}

//	 public List<Integer> largestDivisibleSubset(int[] nums) {
//	        List<Integer> result = new ArrayList<Integer>();
//	        Arrays.sort(nums);
//	        for(int i=0;i<nums.length;i++){
//	            List<Integer> temp = new ArrayList<Integer>();
//	            temp.add(nums[i]);
//	            ldsUtil(nums,i+1,temp,result);
//	            temp.remove(temp.size()-1);
//	        }
//	        return result;
//	    }
//	    
//	    public void ldsUtil(int[] nums,int currentIndex,List<Integer> temp,List<Integer> result){
//	        if(currentIndex == nums.length){
//	            if(temp.size()>result.size()){
//	                System.out.println(temp.toString());
//	                result.clear();
//	                result.addAll(temp);
//	            }
//	        }
//	        
//	        for(int i=currentIndex;i<nums.length;i++){
//
//	            if(temp.get(temp.size()-1) % nums[i]==0 || nums[i]%temp.get(temp.size()-1)==0){
//	                    temp.add(nums[i]);
//	                    ldsUtil(nums,i+1,temp,result);
//	                    temp.remove(temp.size()-1);
//	            }
//	            
//	            ldsUtil(nums,i+1,temp,result);
//	        }
//	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		divisibleSubset ds = new divisibleSubset();
		int[] nums = {1,2,4,8};
		System.out.println(ds.largestDivisibleSubset(nums));

	}

}
