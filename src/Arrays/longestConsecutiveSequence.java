package Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class longestConsecutiveSequence {

	public static int lcs(int[] array){
		if(array == null || array.length ==0) return 0;
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(Arrays.stream(array).boxed().collect(Collectors.toSet()));
//		System.out.println(set);
		Queue<Integer> queue = new LinkedList<Integer>();
		int maxCount = 1;
		int currentCount =1;
		for(int i=0;i<array.length && !set.isEmpty();i++){
			queue.add(array[i]);
			currentCount = 1;
			while(!queue.isEmpty()){
				int current = queue.poll();
				set.remove(current);
				if(set.contains(current+1)){
					queue.add(current+1);
					set.remove(current+1);
					currentCount++;
				}
				if(set.contains(current-1)){
					queue.add(current-1);
					set.remove(current-1);
					currentCount++;
				}				
			}
			
			if(currentCount > maxCount) maxCount = currentCount;
		}
		
		
		return maxCount;
	}
	public static void main(String[] args) {
		int[] array = {100, 4, 200, 1, 3, 2};
		System.out.println(lcs(array));
	}
}

/*
 * Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++){
			map.put(array[i],1);
		}
		for(int i=0;i<array.length;i++){
			int count =0;
			if(map.containsKey(array[i]-1)){
				count = map.get(array[i]-1);
				map.put(array[i]-1, ++count);
			}
			else if(map.containsKey(array[i]+1)){
				count = map.get(array[i]+1);
				map.put(array[i]+1, ++count);
			}
		
			if(count>result) result
			= count;
		}
*/
