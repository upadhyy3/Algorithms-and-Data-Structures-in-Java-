package uber;

public class Power {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;

		double residue = 1;
		double current = x;
		int i = 1;
		while (n != 0) {
			System.out.println(Integer.toBinaryString(n));
			if (n % 2 != 0) {
				residue *= x;
			}
			// else {
			current *= current;
			// }
			n = n >> i;
			i++;
		}
		return (residue * current);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power pw = new Power();
		System.out.println(pw.myPow(3, 5));
	}

}
