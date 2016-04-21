package puzzles;

import java.util.HashMap;
import java.util.Map;

public class ArithmaticExpressionTargetValue {

	Map<Integer,String> map = new HashMap<Integer,String>();
	public static String findArithmaticExpression(int[] nums,int target){
		
		String result = "";
		String operators = "+-/*";
		int first =0;
		int second = 0;
//		Queue<>
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				for(int k=0;k<operators.length();k++){
					
				}
			}
		}
		
	return "";	
	}
	
	public void recursion(int nums[],int currentIndex){
		
	}
	
	public static int compute(char first, char second , char operator){
		int result =0;
		switch(operator){
			case '+' :	result = Character.getNumericValue(first) + Character.getNumericValue(second);
						break;
			case '*' :	result = Character.getNumericValue(first) * Character.getNumericValue(second);
						break;
			case '/' :	result = Character.getNumericValue(first) / Character.getNumericValue(second);
						break;
			case '-' :	result = Character.getNumericValue(first) - Character.getNumericValue(second);
						break;
		}
		return result;
	}
	
	public static void main(String args[]){
		int[] nums = {9,8,4};
		findArithmaticExpression(nums,18);
		System.out.println(compute('2','3','+'));
		System.out.println(Integer.toBinaryString(23));
		int number = (23 << 4) + (1<<1);
		System.out.println(Integer.toBinaryString(number));
	}
}
