package DynamicProgramming;

import java.util.*;
public class longestPalindromicSubsequence {

	int maxLength = Integer.MIN_VALUE;

	public int lpsRecursive(String string) {
		lpsRecursiveUtil(string, new StringBuilder());
		return maxLength;
	}

	public void lpsRecursiveUtil(String current, StringBuilder temp) {
		if (current == null || current.length() == 0) {
			String test = temp.toString();

			if (isPalindrome(test)) {
				System.out.println(test);
				maxLength = Math.max(test.length(), maxLength);
			}
			return;
		}

		// include
		lpsRecursiveUtil(current.substring(1), temp.append(current.charAt(0)));
		temp.deleteCharAt(temp.length() - 1);
		// exclude
		lpsRecursiveUtil(current.substring(1), temp);
	}

	public boolean isPalindrome(String test) {
		if (test == null || test.length() == 0)
			return false;
		int i = 0;
		int j = test.length() - 1;
		while (i < j) {
			if (test.charAt(i) != test.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public int lpsDP(String string){
		int length = string.length();
		if(length == 0) return 0;
		int[][] DP = new int[length][length];
		
		// all diagonal elements will be one, as each character is an palindrome of size 2
		for(int i=0;i<string.length();i++){
			DP[i][i] = 1;
		}

		
		/*
		 *  now we will consider the string of length 2-> 3 -> 4 and so on,
		 *  this way we can compute the bigger substrings with the help of previously calculated 
		 *  substring, which are palindromes
		 */
		for(int len=2;len<=length;len++){
			
			for(int i=0;i<length-len+1;i++){
				int j = i+len-1;
				if(string.charAt(i)==string.charAt(j) && len ==2){
					DP[i][j] =2;
				}
				else if(string.charAt(i)==string.charAt(j)){
					DP[i][j] = DP[i+1][j-1]+2;
				}
				else{
					DP[i][j] = Math.max(DP[i][j-1], DP[i+1][j]);
				}
			}
		}
		return DP[0][length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestPalindromicSubsequence lps = new longestPalindromicSubsequence();
		System.out.println(lps.lpsRecursive("hellolle"));
		// System.out.println(lps.isPalindrome("BBABCBCAB"));
//		System.out.println(lps.lpsDP("BBABCBCAB"));

	}

}
