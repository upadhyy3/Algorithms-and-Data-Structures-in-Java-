package Arrays;
import java.util.*;

public class subarraySum {
	public static int minLength = Integer.MAX_VALUE;
	public static int findSum(int[] array,int sum){
		findSumHelper(array, sum, 0, 0,0);
		return minLength;
	}
	
	public static void findSumHelper(int[] array,int sum,int currentSum,int currentIndex,int currentLength){
		if(sum == currentSum){
			if(subarraySum.minLength > currentLength){
				minLength = currentLength;
			}
			return;
		}
		else if(currentIndex >= array.length){
			return;
		}
		
		//include current index in sum
		findSumHelper(array, sum, currentSum+array[currentIndex], currentIndex+1, currentLength+1);
		//exclude current index in sum
		findSumHelper(array, sum, currentSum, currentIndex+1, currentLength);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 4, 20, 3, 10, 5};
		int sum = 90;
		System.out.println(findSum(array, sum));
	}

}
