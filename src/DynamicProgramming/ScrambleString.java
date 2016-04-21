package DynamicProgramming;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length())
			return false;
		if (s1.equals(s2))
			return true;

		for (int i = 1; i < len; i++) {
			String s1Left = s1.substring(0, i);
			String s1Right = s1.substring(i, len);
			String s2Left = s2.substring(0, i);
			String s2Right = s2.substring(i, len);
			if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right))
				return true;
			s2Left = s2.substring(0, len - i);
			s2Right = s2.substring(len - i, len);
			if (isScramble(s1Left, s2Right) && isScramble(s1Right, s2Left))
				return true;
		}

		return false;
	}

	public static void main(String[] args){
		ScrambleString sb = new ScrambleString();
		System.out.println(sb.isScramble("great", "rgeat"));
	}
}
