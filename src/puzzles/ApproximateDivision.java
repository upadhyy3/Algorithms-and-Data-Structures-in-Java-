package puzzles;

public class ApproximateDivision {

	public static double quotient(int a, int b, int terms){
		double result = a;
		int d = 1;
		int power = 0;
		double termSum =0;
		while(d<b){
			d = d<<1;
		}
		while(power < terms){
			termSum+= Math.pow(d-b,power)/Math.pow(d, power+1);
			power++;
		}
		return result*termSum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2;
		int b =5;
		int terms = 2;
		System.out.println(quotient(a, b, terms));

	}

}
