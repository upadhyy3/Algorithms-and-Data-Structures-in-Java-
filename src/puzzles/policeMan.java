package puzzles;

import java.util.Arrays;
import java.util.Scanner;

public class policeMan {
	public static int finalPrice = Integer.MAX_VALUE;

	/*
	 * Recursive solution
	 */
//	public static int computePrice(int[] locations, int wedges) {
//		// two options higher a new officer or pay petrol price
//		int source = locations[0];	
//		priceRecursionHelper(wedges, source, 1, locations, wedges,0);
//		return finalPrice;
//	}
//
//	public static void priceRecursionHelper(int currentPrice, int source,
//			int currentIndex, int[] locations, int wedges,int previousPetrolPrice) {
//		if (currentIndex >= locations.length) {
//			System.out.println("Came inside outer if");
//			System.out.println("Current Price" + currentPrice);
//			if (finalPrice > currentPrice) {
//				finalPrice = currentPrice;
//				System.out.println("Came inside loop");
//			}
//			return;
//		}
//		// new recruit
//		priceRecursionHelper(currentPrice + wedges, locations[currentIndex],
//				currentIndex + 1, locations, wedges,0);
//
//		// compute petrol
//		int cost = (int) computePetrolPrice(source, locations[currentIndex]);
//		priceRecursionHelper(currentPrice + cost-previousPetrolPrice, source, currentIndex + 1,
//				locations, wedges,cost);
//
//	}
//	public static double computePetrolPrice(int source, int destination) {
//		double cost = Math.pow(destination - source, 2);
//		return cost;
//	}

	public static int computePriceDP(int[] locations, int wedges){
		int[] DP = new int[locations.length];
		DP[0] = wedges;
		int currentIndex  = 1;
		int currentMin = 0;
		int previousMin = 0;
		while(currentIndex<locations.length){
			currentMin = wedges + DP[currentIndex-1];
			for(int i=0;i<currentIndex;i++){
				if(i==0){
					previousMin = 0;
				}
				else{
					previousMin = DP[i-1];
				}
				
				currentMin =Math.min(currentMin, previousMin + wedges+computePetrolPrice(locations,i,currentIndex));
			}
			DP[currentIndex] = currentMin;
			currentIndex++;
		}
		return DP[locations.length-1];
		
	}
	public static int computePetrolPrice(int[] locations,int source, int destination) {
		double cost = Math.pow(locations[destination] - locations[source], 2);
		return (int)cost;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner reader = new Scanner(System.in); // Reading from System.in
		String input = reader.nextLine();
		String[] array = input.split("\\s");
		int numberOfCriminals = Integer.parseInt(array[0]);
		int wedges = Integer.parseInt(array[1]);
		System.out.println(numberOfCriminals);
		int[] criminalPositions = new int[numberOfCriminals];
		input = reader.nextLine();
		array = input.split("\\s");
		int i = 0;
		while (i < numberOfCriminals) {
			criminalPositions[i] = Integer.parseInt(array[i]);
			i++;
		}
		reader.close();
		System.out.println(Arrays.toString(criminalPositions));
		System.out.println(computePriceDP(criminalPositions, wedges));
	}
}
