package Arrays;

import java.util.Arrays;

public class RotateArray {

	public static void rotateArray(int[] array, int n) {
		for(int i=0;i<n;i++){
			rotateOne(array);
		}
	}
	
	public static void rotateOne(int[] array){
		int temp = array[0];
		int i=0;
		for(;i<array.length-1;i++)
		array[i] = array[i+1];
		array[i] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int n = 2;
		rotateArray(array, n);
		System.out.println(Arrays.toString(array));
	}
}
