package puzzles;

import java.util.Scanner;

public class SubStringSum {

	public static int getMaxLengthSubString(String string) {
		int maxLength = 0;
		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j < string.length(); j = j + 2) {
				String current = string.substring(i, j + 1);
				if (isBalanced(current) && current.length() > maxLength) {
					maxLength = current.length();
					System.out.println(current);
				}
			}
		}
		return maxLength;
	}

	public static boolean isBalanced(String current) {
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < current.length(); i++) {
			if (i < current.length()/2) {
				leftSum += Character.getNumericValue(current.charAt(i));
			} else {
				rightSum += Character.getNumericValue(current.charAt(i));
			}
		}

		return (leftSum == rightSum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "1538023";
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		System.out.println(number);
		String[] str = new String[number];
		int i=0;
		while(i<number){
			str[i] = s.next();
			i++;
		}
		for(int j=0;j<number;j++){
			System.out.println(getMaxLengthSubString(str[j]));
		}
		

	}

}
