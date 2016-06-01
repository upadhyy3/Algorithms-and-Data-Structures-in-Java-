package String;

import java.util.*;

public class PatternSearch {

	public static int[] getLPS(String pattern) {
		int[] lps = new int[pattern.length()];
		int i = 1;
		int j = 0;
		lps[0] = 0;
		while (i < pattern.length() && j < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					lps[i] = j;
					i++;
				}
			}

		}
		return lps;
	}

	public static boolean patternMatch(String pattern, String text) {
		int[] lps = getLPS(pattern);
		int i = 1;
		int j = 0;
		lps[0] = 0;
		while (i < text.length() && j < pattern.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

		if(j== pattern.length()) return true;
		return false;
	}

	public static void main(String[] args) {
		String pattern = "abcdabcy";
		String text = "abcxabcdabcdabcy";
		System.out.println(patternMatch(pattern, text));
	}
}
