package puzzles;

import java.util.ArrayList;
import java.util.Iterator;

public class InterestingDigits {
	
	public static int[] digits(int base){
		ArrayList<Integer> digitList = new ArrayList<Integer>();
		for(int start=2;start<base;start++){
			if(isInteresting(start,base)){
				digitList.add(start);
			}
		}
	    int[] ret = new int[digitList.size()];
	    Iterator<Integer> iterator = digitList.iterator();
	    for (int i = 0; i < ret.length; i++)
	    {
	        ret[i] = iterator.next().intValue();
	    }
	    
	    return ret;
	}
	
	public static boolean isInteresting(int digit,int base){
		for(int i=0;i<base*base*base;i+=digit){
			int sum =0;
			int n=i;
			while(n>0){
				sum+= n%base;
				n = n/base;
			}
			if(sum%digit >0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int base = 26;
		System.out.println(digits(base));

	}

}
