//package Arrays;
//
//public class MaximumRepeatingNumber {
//
//	public static int getMostPopularNumber(int[] array){
//		int k = array.length;
//		int result =-1;
//		for(int i=0;i<array.length;i++){
//			array[array[i]%k] = array[array[i]%k]+k;
//		}
//		int max = Integer.MIN_VALUE;
//		for(int i=0;i<array.length;i++){
//			if(array[i] > max){
//				max = array[i];
//				result = i;
//			}
//		}
//		return result;
//	}
//	public static void main(String[] args) {
//		int[] array = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
//		System.out.println(getMostPopularNumber(array));
//	}
//}
