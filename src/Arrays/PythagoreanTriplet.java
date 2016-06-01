package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class PythagoreanTriplet {

	public static boolean tripletExists(Integer[] array) {
		Arrays.sort(array, Collections.reverseOrder());
		int a = 0;
		int b =0;
		int c = 0;
		int i,j,k;
		i=j=k=0;
		for(;i<array.length;i++){
			c = array[i];
			j=i+1;
			k= array.length-1;
			while(j < k){
				b = array[j];
				a = array[k];
				if(Math.pow(c, 2) == (Math.pow(b, 2)+Math.pow(a, 2))){
					System.out.println("a:" + a + " b:" + b + " c:"+ c);
					return true;
				}
				else if(Math.pow(c, 2) < (Math.pow(b, 2)+Math.pow(a, 2))){
					j++;
				}
				else{
					k--;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Integer arr[] = { 3, 1, 4, 6, 5 };
		System.out.println(tripletExists(arr));
	}
}
