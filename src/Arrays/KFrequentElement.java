package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KFrequentElement {
	class Node {
	
		int value;
		int count;
		public Node(int value,int count){
//			super();
			this.value = value;
			this.count = count;
		}
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);
        KFrequentElement obj = new KFrequentElement();
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.count == o2.count) return 0;
				else if(o1.count > o2.count) return -1;
				else return 1;
			}
        	
        });
        int currentCount = 1;
        int previousElement = nums[0];
        for(int i=1;i<nums.length;i++){
        	if(previousElement == nums[i]){
        		currentCount++;
        	}
        	else{
        		Node newNode = obj.new Node(previousElement,currentCount);
        		queue.offer(newNode);
        		previousElement = nums[i];
        		currentCount =1;
        	}
        	
        	if(i == nums.length-1){
        		Node newNode = obj.new Node(previousElement,currentCount);
        		queue.offer(newNode);
        	}
        }
        
        while(!queue.isEmpty() && k>0){
        	Node temp = queue.poll();
        	result.add(temp.value);
        	k--;
        }
        return result;
    }
	
	public static void main(String[] args){
		int[] arr = {1,1,1,2,2,3,3,3,3,3,3,4,5,2,1,9,8,3};
		int k = 2;
		System.out.println(topKFrequent(arr, k));
	}
}
