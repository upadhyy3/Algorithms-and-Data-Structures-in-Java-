package DynamicProgramming;

import java.util.*;
public class bitonicSubsequence {

	public static int longestBitonicSubSeq(int[] array){
		int result = 0;
		int[] DPIncreasing = new int[array.length];
		int[] DPDecreasing = new int[array.length];
		DPIncreasing[0] = 1;
		int maximum = 0;
		Arrays.fill(DPIncreasing, 1);
		Arrays.fill(DPDecreasing, 1);
		//increasing sequence at every index;
		for(int i=1;i<array.length;i++){
			for(int j=0;j<i;j++){
				if(array[j]<array[i] && DPIncreasing[j]+1>DPIncreasing[i]){
					DPIncreasing[i] = DPIncreasing[j]+1;
				}
			}
		}
		System.out.println(Arrays.toString(DPIncreasing));
		//decreasing sequence in reverse order
		for(int i=array.length-2;i>=0;i--){
			for(int j=array.length-1;j>i;j--){
				if(array[i]>array[j] && DPDecreasing[j]+1>DPDecreasing[i]){
					DPDecreasing[i] = DPDecreasing[j]+1;
				}
			}
		}
		System.out.println(Arrays.toString(DPDecreasing));
		
		for(int i=0;i<array.length;i++){
			maximum = Math.max(DPIncreasing[i]+DPDecreasing[i]-1, maximum);
		}
		
		return maximum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {80, 60, 30, 40, 20, 10};
		System.out.println(longestBitonicSubSeq(array));

	}

}
