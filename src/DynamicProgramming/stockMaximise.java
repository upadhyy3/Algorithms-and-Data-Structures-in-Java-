package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stockMaximise {

	public static long calcmaxProfit(long[] array) {
		return maxProfitUtil(0, array, 0, 0);
	}

	public static long maxProfitUtil(int currentIndex, long[] array, long currentProfit,
			int currentStockCount) {
		if (currentIndex == array.length) {
			return currentProfit;
		}
		int n = 1;
		long nobuy = maxProfitUtil(currentIndex + 1, array, currentProfit,
				currentStockCount);
		long buy = maxProfitUtil(currentIndex + 1, array, currentProfit
				- array[currentIndex], currentStockCount + 1);
		long sell = 0;
		while (n <= currentStockCount) {
			sell = Math.max(
					sell,
					maxProfitUtil(currentIndex + 1, array, currentProfit + n
							* array[currentIndex], currentStockCount - n));
			n++;
		}

		return Math.max(nobuy, Math.max(buy, sell));
	}
	
	private static long[] getElements(String elements, int size) {

		String[] elementsArray = elements.trim().split(" ");

		if (elementsArray.length != size)
			throw new IllegalArgumentException("Number of elements in the list does not match the size provided");

		long[] numbers = new long[size];
		int index = 0;

		// extract integers
		for (String ele : elementsArray) {
			try {
				numbers[index++] = Long.parseLong(ele);
			} catch (NumberFormatException nfe) {
				System.out.println("Caught NumberFormatException: Unable to parse to long");
				nfe.getStackTrace();
			}

		}
		return numbers;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		try {
			int testCases = Integer.parseInt(input.readLine().trim());

			if (testCases <= 0) {
				throw new IllegalArgumentException("The number of test cases must be greater than 0");
			}

			while (testCases > 0) {
				int days = Integer.parseInt(input.readLine().trim());
				if (days <= 0) {
					throw new IllegalArgumentException("The number of test cases must be greater than 0");
				}
				long[] stockPrices = getElements(input.readLine(), days);

				long maxProfit = calcmaxProfit(stockPrices);
				System.out.println(maxProfit);
				testCases--;
			}
			input.close();
		} catch (NumberFormatException nfe) {
			System.out.println("Caught NumberFormatException: Unable to parse inputs from stdin");
			nfe.getStackTrace();
		} catch (IOException ioe) {
			System.out.println("Caught IOException: Unable to read inputs from stdin");
			ioe.getStackTrace();
		}
	}
	

}
