package String;

import java.util.*;

public class stringSimilarity {

	// compute z index
	static int[] calculatez(String str) {
		int[] z = new int[str.length()];
		int l = 0;
		int r = 0;
		int k = 1;
		z[0] = 0;

		for (; k < str.length(); k++) {
			if (k>r) {
				l = r = k;
				while (r < str.length() && str.charAt(r) == str.charAt(r - l)) {
					r++;
				}
				z[k] = r - l;
				r--;
			} else {

				int k1 = k - l;
				if (z[k1] < r - k + 1) {
					z[k] = z[k1];
				} else {
					l = k;
					while (r < str.length()
							&& str.charAt(r) == str.charAt(r - l)) {
						r++;
					}
					z[k] = r - l;
					r--;
				}
			}
		}
		return z;
	}

	// compute N2 method
	static long computeLPS(String str) {
		int i = 0;
		int j = str.length() - 1;
		long sum = 0;
		while (j >= 0) {
			int k = j;
			int match = 0;
			i = 0;
			while (k < str.length() && str.charAt(i) == str.charAt(k)) {
				match++;
				i++;
				k++;
			}
			sum += match;
			j--;
		}

		System.out.println(sum);
		return sum;
	}

	static int findsimilarityScore(String test) {
		int[] z = calculatez(test);
		int sum = test.length();
		for (int i = 0; i < z.length; i++) {
			sum += z[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "ababaa";
//		System.out.println(computeLPS("aa"));
		
		System.out.println(findsimilarityScore(test));
	}

}
