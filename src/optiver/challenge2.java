package optiver;

import java.util.*;

public class challenge2 {

//    static int ThirdLargest(int[] arr) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10, Collections.reverseOrder());;
//        Set<Integer> set = new HashSet<Integer>();
//        
//        for(int i=0;i<arr.length;i++){
//        	if(set.contains(arr[i])){
//        		continue;
//        	}
//        	else{
//        		set.add(arr[i]);
//        		queue.offer(arr[i]);
//        	}
//        	
//        }
//        
////        System.out.println(queue.toString());
//        int i=2;
//        while(i>0 && !queue.isEmpty()){
//        	queue.poll();
//        	i--;
//        }
//        
//        return queue.peek();
//      }

    static int ThirdLargest(int[] arr) {
    	if (arr == null) {
    		return 0;
    	}
     
    	return get3rd(arr.length - 3 +1, arr, 0, arr.length - 1);
    }
     
    static int get3rd(int k, int[] nums, int start, int end) {
     
    	int pivot = nums[end];
     
    	int left = start;
    	int right = end;
     
    	while (true) {
     
    		while (nums[left] < pivot && left < right) {
    			left++;
    		}
     
    		while (nums[right] >= pivot && right > left) {
    			right--;
    		}
     
    		if (left == right) {
    			break;
    		}
     
    		swap(nums, left, right);
    	}
     
    	swap(nums, left, end);
     
    	if (k == left + 1) {
    		return pivot;
    	} else if (k < left + 1) {
    		return get3rd(k, nums, start, left - 1);
    	} else {
    		return get3rd(k, nums, left + 1, end);
    	}
    }
     
    static void swap(int[] nums, int n1, int n2) {
    	int tmp = nums[n1];
    	nums[n1] = nums[n2];
    	nums[n2] = tmp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {3,12,14,6,8,1,12};
		System.out.println(ThirdLargest(array));

	}

}
