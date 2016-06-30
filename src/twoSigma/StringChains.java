/**
 * 
 */
package twoSigma;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

/**
 * @author admin
 *
 */
public class StringChains {

	/**
	 * @param args
	 */

	/*
	 * Complete the function below.
	 */
	/*
	 * class variable which stores the maximum length
	 */
	static int maxChain = 1;

	static int longestChain(String[] words) {

		if (words == null || words.length == 0)
			return 0;

		// Used set for O(1) access to all the words in the given string array
		Set<String> dictionary = new HashSet<String>();
		dictionary.addAll(Arrays.asList(words));
		Map<String, Integer> map = new HashMap<String, Integer>();
		int max = 1;
		// Iterate through given words and call the helper function
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				max = Math.max(max, map.get(words[i]));
			} else {
				max = Math.max(max,
						longestChainHelper(words[i], dictionary, 1, map));
				map.put(words[i], max);
			}

		}

		return max;
	}

	// recursive helper function which removes a character from a given word and
	// checks whether it is present in the dictionary
	// if word after removal of a character is present in the dictionary ,
	// function increases the currentChain parameter which
	// stores the current chain length
	public static int longestChainHelper(String currentWord,
			Set<String> dictionary, int currentChain, Map<String, Integer> map) {

		// //checks whether current chain length is greater than running maximum
		// if(currentChain > maxChain)
		// max= currentChain;
		if (currentWord.length() <= 1)
			return currentChain;

//		if (map.containsKey(currentWord)) {
//			return map.get(currentWord);
//		}

		// check if removing characters can genereate other words in the
		// dictionary
		String current = "";
		char deletedCharacter = ' ';
		StringBuilder sb = new StringBuilder(currentWord);
		int max = 1;
		for (int i = 0; i < sb.length(); i++) {
			deletedCharacter = sb.charAt(i);
			current = sb.deleteCharAt(i).toString();

			if (dictionary.contains(current)) {

				if (map.containsKey(current)) {
					max = Math.max(max, map.get(current)+1);
				} else {
					max = Math.max(
							max,
							longestChainHelper(current, dictionary,
									currentChain + 1, map));
					map.put(current, max);
				}
				// max = Math.max(
				// max,
				// longestChainHelper(current, dictionary,
				// currentChain + 1,map));
			}

			sb.insert(i, deletedCharacter);
		}
		return max;
	}

	public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		System.out.println(longestChain(words));
	}

}
