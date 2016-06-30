package Arrays;

import java.util.*;
import java.util.Scanner;
public class ConsecutiveSubsequences
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();

		for(int l = 0; l < tests; l++)
		{
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			long[] numbers = new long[n];

			for(int i = 0; i < n; i++)
			{
				numbers[i] = scanner.nextLong();
			}

			System.out.println(k);
			long[] prefixModCount = new long[k];
			for(int i = 0; i < k; i++)
			{
				prefixModCount[i] = 0;
			}
			prefixModCount[0] = 1;

			int prefixSum = 0;
			for(int i = 0; i < numbers.length; i++)
			{
				prefixSum += numbers[i];
				prefixSum %= k;
				prefixModCount[prefixSum] += 1;
			}

			long result = 0;
			System.out.println(Arrays.toString(prefixModCount));
			for(int mod = 0; mod < k; mod++)
			{
				result += prefixModCount[mod] * (prefixModCount[mod] - 1) / 2;
			}
			System.out.println(result);
		}

		scanner.close();
	}
}
