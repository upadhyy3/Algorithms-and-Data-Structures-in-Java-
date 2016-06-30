package Dropbox;

import java.util.*;

public class redBlue {

	static void getWords(String input, int minLenght, int leftOver,
			ArrayList<ArrayList<String>> stringCombination,
			ArrayList<String> temp) {
		if (input == null || input.length() == 0) {
			stringCombination.add(new ArrayList<String>(temp));
			return;
		} else if (input.length() < minLenght) {
			return;
		}

		for (int i = 0; i <= leftOver; i++) {
			temp.add(input.substring(0, minLenght + i));
			getWords(input.substring(minLenght + i), minLenght, leftOver - i,
					stringCombination, temp);
			temp.remove(temp.size() - 1);
		}
	}

	static int wordpattern(String pattern, String input) {

		int minLenght = input.length() / pattern.length();
		int leftOver = input.length() - pattern.length() * minLenght;
//		System.out.println(minLenght);
//		System.out.println(leftOver);
		ArrayList<ArrayList<String>> stringCobination = new ArrayList<ArrayList<String>>();
		getWords(input, minLenght, leftOver, stringCobination,
				new ArrayList<String>());
		boolean[] validCombination = new boolean[stringCobination.size()];
		Arrays.fill(validCombination, true);
		int index = 0;
		for (ArrayList<String> current : stringCobination) {
			HashMap<Character, String> mappings = new HashMap<>();

			// String[] words = str.split(" ");
			char[] patternLetters = pattern.toCharArray();

			if (current.size() != patternLetters.length){
				validCombination[index] = false;
				continue;
			}
				

			for (int i = 0; i < patternLetters.length; i++) {
				if (mappings.get(patternLetters[i]) != null
						&& !mappings.get(patternLetters[i]).equals(
								current.get(i))){
					validCombination[index] = false;
					index++;
					break;
				}
				else if (mappings.get(patternLetters[i]) == null
						&& mappings.containsValue(current.get(i))){
					validCombination[index] = false;
					index++;
					break;
				}
				else{
					mappings.put(patternLetters[i], current.get(i));
				}
					
			}
		}
		
		for(boolean isValid:validCombination){
			if(isValid) return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "redbluebluered";
		String pattern = "abba";
		System.out.println(wordpattern(pattern, input));
	}

}
