package Arrays;

import java.util.ArrayList;

public class productOfThree {

	static int maxProduct = Integer.MIN_VALUE;
	public static int getProduct(int[] array){
		if(array == null || array.length <3) return 0;
		
		getProductUtil(array, 0, new ArrayList<Integer>());
		return maxProduct;
	}
	
	public static void getProductUtil(int[] array,int currentIndex,ArrayList<Integer> temp){
		if(temp.size() == 3){
			int currentProduct = computeProduct(temp);
			System.out.println(temp);
			if(currentProduct > maxProduct){
				maxProduct = currentProduct;
			}
			return;
		}
		else if(currentIndex == array.length || temp.size() > 3){
			return;
		}
		
		for( int i= currentIndex;i<array.length;i++){
//			getProductUtil(array, currentIndex+1, temp);
			temp.add(array[i]);
			getProductUtil(array, i+1, temp);
			temp.remove(temp.size()-1);
		}
		
		return;
	}
	
	//O(n) solution
	
//	public static int getProd(int[] array){
//		if(array == null || array.length <3) return 0;
//		int maxProd3 = array[0]*array[1]*array[2];
//		int maxProd2 = array[0]*array[1];
//		int lowProd2 = array[0]*array[1];
//		int highest = Math.max(array[0],array[1]);
//		int lowest = Math.min(array[0],array[1]);
//		
//		for(int i=2; i< array.length;i++){
//			int current = array[i];
//			maxProd3 = Math.max(maxProd3,Math.max(maxProd2*current,lowProd2*current));
//			maxProd2 = Math.max(maxProd2,Math.max(highest*current,lowest*current));
//			
//		}
//	}
	
	public static int computeProduct(ArrayList<Integer> list){
		int prod = 1;
		for(Integer i:list){
			prod *= i;
		}
		
		return prod;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {-5,-3,-2,-1};
		System.out.println(getProduct(array));

	}

}
