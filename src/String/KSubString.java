package String;

import java.util.Deque;
import java.util.LinkedList;

public class KSubString {

	public static String kString(String string, int k) {
		if (string == null || string.length() == 0)
			return "";

		int length = string.length();
		String longest = "";
		for (int i = k; i <= length; i++) {
			for (int j = 0; j <= length - i; j++) {
				String current = string.substring(j, j + i);
				// System.out.println(current);
				if (isValid(current, k) && longest.length() < current.length()) {
					longest = current;
				}
			}
		}

		return longest;
	}

	public static boolean isValid(String current, int m) {
		boolean[] charCount = new boolean[26];
		int count = 0;
		for (char c : current.toCharArray()) {

			if (charCount[c - 'a']) {
				continue;
			} else {
				charCount[c - 'a'] = true;
				count++;
			}
		}

		if (count == m)
			return true;
		else
			return false;
	}

//	public static String kStringN(String string) {
//		if (string == null || string.length() == 0)
//			return "";
//		
//		Deque<Integer> queue = new LinkedList<Integer>();
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(kString("aabbcc", 3));
	}

}
