package puzzles;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StreetParking {

	public int freeParks(String street) {
		int numberOfParking = 0;
		if (street == null || street.length() == 0)
			return numberOfParking;
		for (int i = 0; i < street.length(); i++) {
			if (street.charAt(i) != '-') {
				continue;
			}
			if (isVAlidSpot(street, i)) {
				numberOfParking++;
			}
		}
		return numberOfParking;
	}

	public boolean isVAlidSpot(String street, int index) {

		// checking for 5 meter range
		if (index + 2 < street.length()) {
			if (street.charAt(index + 2) == 'B'
					|| street.charAt(index + 1) == 'B'
					|| street.charAt(index + 1) == 'S') {
				return false;
			}
		} else if (index + 1 < street.length()) {
			if (street.charAt(index + 1) == 'B'
					|| street.charAt(index + 1) == 'S') {
				return false;
			}
		}

		if (index - 1 > 0) {
			if (street.charAt(index - 1) == 'S') {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String street = "---B--S-D--S--";
		StreetParking sp = new StreetParking();
//		System.out.println(sp.freeParks(street));
		String[] tests = {"---B--S-D--S--","DDBDDBDDBDD","--S--S--S--S--","SSD-B---BD-DDSB-----S-S--------S-B----BSB-S--B-S-D"};
		int[] expectedValues = {4,0,2,14};
		for(int i=0;i<tests.length;i++){
			System.out.println("The Expected Output fot test" + i + "is :" + expectedValues[i] + "And real output is"+ sp.freeParks(tests[i]));
		}
		
	}
}

