package uber;

import java.util.Arrays;

public class closesetIndex {

	// nearest index j for which array[j] > array[i]
	public static int[] findNearestIndex(int[] array) {
		int[] result = new int[array.length];
		int leftIndex = 1;
		int rightIndex = 1;
		boolean findLeft = false;
		boolean findRight = false;
		for(int i=0;i<array.length;i++){
			leftIndex = 1;
			rightIndex = 1;
			findLeft = false;
			findRight = false;
			//find left
			for(int k=i-1;k>=0;k--){
				if(array[k]>array[i]){
					leftIndex = k;
					findLeft = true;
					break;
				}
			}
			//find right
			for(int j=i+1;j<array.length;j++){
				if(array[j]>array[i]){
					rightIndex = j;
					findRight = true;
					break;
				}
			}
			if(findLeft && findRight){
				if(Math.abs(i-leftIndex) > Math.abs(rightIndex-i) ){
					result[i] = rightIndex;
				}
				else{
					result[i] = leftIndex;
				}
			}
			else if(findLeft){
				result[i] = leftIndex;
			}
			else if(findRight){
				result[i] = rightIndex;
			}
			else{
				result[i] = leftIndex;
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,6,3,0,11,5,4};
		System.out.println(Arrays.toString(findNearestIndex(array)));
	}

}
