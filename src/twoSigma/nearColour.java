package twoSigma;

import java.util.*;

public class nearColour {
	static String[] nearestColor(String[] colors) {
		int size = Integer.parseInt(colors[0]);
		String[] result = new String[size];
		int start = 1;
		int end = size;
		ArrayList<ArrayList<Integer>> rgbList = new ArrayList<ArrayList<Integer>>();
		// create a RGB lookup map
		HashMap<String, ArrayList<Integer>> rgbLookUpMap = new HashMap<>();
		ArrayList<Integer> blackList = new ArrayList<>();
		blackList.add(0);
		blackList.add(0);
		blackList.add(0);
		rgbLookUpMap.put("Black", blackList);

		ArrayList<Integer> whiteList = new ArrayList<>();
		whiteList.add(255);
		whiteList.add(255);
		whiteList.add(255);
		rgbLookUpMap.put("White", whiteList);

		ArrayList<Integer> redList = new ArrayList<>();
		redList.add(255);
		redList.add(0);
		redList.add(0);
		rgbLookUpMap.put("Red", redList);

		ArrayList<Integer> greenList = new ArrayList<>();
		greenList.add(0);
		greenList.add(255);
		greenList.add(0);
		rgbLookUpMap.put("Green", greenList);

		ArrayList<Integer> blueList = new ArrayList<>();
		blueList.add(0);
		blueList.add(0);
		blueList.add(255);
		rgbLookUpMap.put("Blue", blueList);

		int index = 0;
		for (int i = start; i <= end; i++) {
			double min = Integer.MAX_VALUE * 1d;
			String key = "";
			String temp = colors[i];
			int r = Integer.parseInt(temp.substring(0, 8), 2);
			int g = Integer.parseInt(temp.substring(8, 16), 2);
			int b = Integer.parseInt(temp.substring(16, 24), 2);

			for (String k : rgbLookUpMap.keySet()) {
				ArrayList<Integer> rgb = rgbLookUpMap.get(k);
				double dist = (int) Math.sqrt(Math.pow(
						(double) (rgb.get(0) - r), 2.0)
						+ Math.pow((double) (rgb.get(1) - g), 2.0)
						+ Math.pow((double) (rgb.get(2) - b), 2.0));
				if (dist < min) {
					min = dist;
					key = k;
				} else if (dist == min) {
					key = "Ambiguous";
				}
			}
			result[index] = key;
			index++;
		}
		return result;

	}
}
