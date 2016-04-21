package DynamicProgramming;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.equals("0"))
			return 0;
		int[] DP = new int[s.length() + 1];
		DP[0] = 1;
		if (validNumber(s.substring(0, 1))) {
			DP[1] = 1;
		} else {
			DP[1] = 0;
		}

		for (int i = 2; i <= s.length(); i++) {

			if (validNumber(s.substring(i - 1, i))) {
				DP[i] += DP[i - 1];
			}

			if (validNumber(s.substring(i - 2, i))) {
				DP[i] += DP[i - 2];
			}

		}
		return DP[s.length()];
	}

	public boolean validNumber(String s) {
		if (s.charAt(0) == '0')
			return false;
		int currentValue = Integer.parseInt(s);
		if (currentValue >= 1 && currentValue <= 26)
			return true;
		return false;
	}

}
