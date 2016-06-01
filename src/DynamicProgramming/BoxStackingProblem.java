package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

class Box {
	public int height;
	public int width;
	public int depth;

	public Box(int height, int width, int depth) {
		this.height = height;
		this.width = width;
		this.depth = depth;
	}
}

public class BoxStackingProblem {

	/*
	 * create permutation of boxes
	 */
	public static Box[] generatePermutation(Box[] array) {
		int n = 3 * array.length;
		int index = 0;
		Box newBox = null;
		Box[] boxes = new Box[n];
		for (int i = 0; i < array.length; i++) {
			// h -> h
			boxes[index] = array[i];
			index++;
			// h -> w
			// used max and min for convention of rest of the two dimension as
			// area will be same no matter what
			newBox = new Box(array[i].width, Math.max(array[i].height,
					array[i].depth), Math.min(array[i].height, array[i].depth));
			boxes[index] = newBox;
			index++;
			// h -> d
			newBox = new Box(array[i].depth, Math.max(array[i].height,
					array[i].width), Math.min(array[i].height, array[i].width));
			boxes[index] = newBox;
			index++;
		}
		return boxes;
	}

	public static int maxStackHeight(Box[] array) {
		Box[] boxes = generatePermutation(array);
		// Sort the boxes in increasing order of base area
		Arrays.sort(boxes, new Comparator<Box>() {
			@Override
			public int compare(Box o1, Box o2) {
				// TODO Auto-generated method stub
				int difference = o2.width * o2.depth - o1.width * o1.depth;
				return difference;
			}
		});

		int[] MHS = new int[boxes.length];
		// Same as LIS
		for (int i = 0; i < boxes.length; i++)
			MHS[i] = boxes[i].height;
		
		for (int i = 1; i < boxes.length; i++) {
			for (int j = 0; j < i; j++) {
				if (boxes[i].depth < boxes[j].depth
						&& boxes[i].width < boxes[j].width
						&& MHS[i] < MHS[j] + boxes[i].height)
					MHS[i] = MHS[j] + boxes[i].height;
			}
		}

		/* Pick maximum of all msh values */
		int max = -1;
		for (int i = 0; i < MHS.length; i++)
			if (max < MHS[i])
				max = MHS[i];
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 4, 1, 4, 10 };
		int[] width = { 6, 2, 5, 12 };
		int[] depth = { 7, 3, 6, 32 };
		int numberOfBoxes = height.length;
		Box[] array = new Box[numberOfBoxes];
		for (int i = 0; i < numberOfBoxes; i++) {
			Box temp = new Box(height[i], width[i], depth[i]);
			array[i] = temp;
		}
		System.out.println(maxStackHeight(array));
	}

}
