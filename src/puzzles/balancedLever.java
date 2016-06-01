package puzzles;

import java.util.ArrayList;

public class balancedLever {

	// public static ArrayList<String> listOfStrings= new ArrayList<String>();
	// public static ArrayList<String> listOfBalancedStrings = new
	// ArrayList<String>();

	public static ArrayList<String> findSubString(String test) {
		ArrayList<String> listOfStrings = new ArrayList<String>();
		String sub = "";
		for (int c = 0; c < test.length(); c++) {
			for (int i = 1; i <= test.length() - c; i++) {
				sub = test.substring(c, c + i);
				listOfStrings.add(sub);
			}
		}
		System.out.println(listOfStrings);
		return listOfStrings;
	}

	public static ArrayList<String> findListOfBalancedStrings(String test) {
		ArrayList<String> listOfBalancedStrings = new ArrayList<String>();
		if (test == null || test.length() == 0)
			return listOfBalancedStrings;
		ArrayList<String> listOfStrings = findSubString(test);
		for (String s : listOfStrings) {
			if (isBalanced(s)) {
				listOfBalancedStrings.add(s);
			}
		}
		return listOfBalancedStrings;
	}

	public static boolean isBalanced(String test) {
		if (test == null || test.length() == 0)
			return false;
		int[] leftWeight = new int[test.length()];
		int[] rightWeight = new int[test.length()];
		int currentCount = 0;
		int numberOfOnes = 0;
		for (int i = 0; i < test.length(); i++) {
			currentCount = currentCount + numberOfOnes;
			leftWeight[i] = currentCount;
			if (test.charAt(i) == '1') {
				numberOfOnes++;
			}
		}

		currentCount = 0;
		numberOfOnes = 0;
		for (int i = test.length() - 1; i >= 0; i--) {
			currentCount = currentCount + numberOfOnes;
			rightWeight[i] = currentCount;
			if (test.charAt(i) == '1') {
				numberOfOnes++;
			}
		}

//		System.out.println(Arrays.toString(leftWeight));
//		System.out.println(Arrays.toString(rightWeight));

		for (int i = 0; i < test.length(); i++) {
			if (leftWeight[i] == rightWeight[i]) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
//		 String test = "10100001";
		// String test = "101001";
//		String test = "001";
		 String test = "1011";
		System.out.println(findListOfBalancedStrings(test));

	}
}
