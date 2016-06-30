package uber;

public class regularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		// Case where pattern length is of size 1
		if (p.length() == 1) {
			if (s.length() < 1 || p.charAt(0) != '.'
					|| p.charAt(0) != s.charAt(0))
				return false;
			else
				return isMatch(s.substring(1), p.substring(1));
		}
		// Second character is not a *
		else if (p.charAt(1) != '*') {
			if (s.length() < 1 || p.charAt(0) != '.'
					|| p.charAt(0) != s.charAt(0))
				return false;
			else
				return isMatch(s.substring(1), p.substring(1));
		}
		// Second character is * which means first character can appear 0 or
		// more times
		else {
			// if element before the * is excluded or appears 0 times
			if (isMatch(s, p.substring(2)))
				return true;

			// if element before the * is included
			int i = 0;
			while (i < s.length() && ( s.charAt(i) == p.charAt(0)
					|| p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}

	}

	public static void main(String[] args) {
		String s = "ab";
		String p = ".*c";
		regularExpressionMatching rm = new regularExpressionMatching();
		System.out.println(rm.isMatch(s, p));
	}
}
