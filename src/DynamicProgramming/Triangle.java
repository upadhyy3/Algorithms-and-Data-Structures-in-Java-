package DynamicProgramming;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] min = new int[triangle.size()];
		int biggestRowLength = triangle.size();
		for (int i = 0; i < biggestRowLength; i++) {
			min[i] = triangle.get(biggestRowLength - 1).get(i);
		}

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				min[j] = triangle.get(i).get(j) + Math.min(min[j], min[j + 1]);
			}
		}

		return min[0];
	}
}
