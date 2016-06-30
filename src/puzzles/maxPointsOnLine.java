package puzzles;

/**
 * Definition for a point.
 */
class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}

}

class Line {
	double slope;
	double constant;

	Line(double slope, double constant) {
		this.slope = slope;
		this.constant = constant;
	}

	Line(double constant) {
		this.constant = constant;
	}
}

public class maxPointsOnLine {

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		Point point1 = null;
		Point point2 = null;
		int maxPoints = 1;
		int count = 0;
		for (int i = 0; i < points.length; i++) {
			point1 = points[i];
			for (int j = i + 1; j < points.length; j++) {
				point2 = points[j];
				// if(point1.x == point2.x && point1.y == point2.y) continue;
				Line currentLine = computeEquation(point1, point2);
				// count point that lies on this line
				count = 0;
				for (int k = 0; k < points.length; k++) {
					if ((points[k].y - ((currentLine.slope) * points[k].x) - currentLine.constant) == 0) {
						count++;
					}
				}
				if (count > maxPoints)
					maxPoints = count;
			}
		}

		return maxPoints;
	}

	// slope intercept equation
	public Line computeEquation(Point point1, Point point2) {
		double slope = 0;
		double constant = 0;
		if (point1.y == point2.y) {
			constant = point1.y;
			Line line = new Line(constant);
			return line;

		} else if (point1.x == point2.x) {
			constant = point1.x;
			Line line = new Line(constant);
			return line;
		}
		slope = (point2.y - point1.y) / (point2.x - point1.x);
		constant = point1.y - (slope) * point1.x;
		Line line = new Line(slope, constant);
		return line;
	}

	public static void main(String[] args) {
		Point[] points = { new Point(0, 0), new Point(0, 0) };// ,new
																// Point(3,3),new
																// Point(4,4),new
																// Point(6,9)};
		maxPointsOnLine mp = new maxPointsOnLine();
		int result = mp.maxPoints(points);
		System.out.println(result);
	}
}
