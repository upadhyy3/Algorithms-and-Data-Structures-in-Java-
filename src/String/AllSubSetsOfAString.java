package String;

import java.util.ArrayList;

public class AllSubSetsOfAString {
	public static ArrayList<String> allSubsetsOfAString(String s) {
		ArrayList<String> result = new ArrayList<String>();
		result.add("");
		for (int i = 0; i < s.length(); i++) {
			ArrayList<String> temp = new ArrayList<String>();
			for (String current : result) {
				temp.add(current + s.charAt(i));
			}
			result.addAll(temp);
		}
		result.remove(0);
		return result;
	}

	public static void main(String[] args) {
		String test = "abc";
		System.out.println(allSubsetsOfAString(test));
	}
}
