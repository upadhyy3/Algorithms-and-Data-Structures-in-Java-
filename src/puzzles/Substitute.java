package puzzles;

/*
 * TopCoder : Substitute
 */
public class Substitute {

	public static int getValue(String key, String code) {
		int value = 0;
		int multiplier = 1;
		// int bitMap = computeBitMap(key);
		for (int i = 0; i < code.length(); i++) {
			for (int j = 0; j < key.length(); j++) {
				if (code.charAt(i) == key.charAt(j)) {
					if (j < key.length()-1) {
						System.out.println(j+1);
						value = value * multiplier + (j + 1);
					}
					multiplier *= 10;
				}
			}
		}
		return value;
	}
}

// public class Substitute { 
//     public int getValue(String key, String code) {
//
//         int result = 0;
// 
//         for (int i = 0; i < code.length(); i++) {
// 
//             int p = key.indexOf(code.charAt(i));
// 
//             if (p >= 0) {
//                 result *= 10;
//                 result += (p + 1) % 10;
//             }
// 
//         }
// 
//         return result;
// 
//     }
// }
//public static int computeBitMap(String s) {
//int result = 0;
//for (int i = 0; i < s.length(); i++) {
//	result |= 1 << (s.charAt(i) - 'a');
//}
//return result;
//}

//public static void main(String[] args) {
//String key = "TRADINGFEW";
//String code = "LGXWEV";
//System.out.println(getValue(key, code));
//}