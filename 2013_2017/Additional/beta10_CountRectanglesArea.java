package Additional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Point {
	int x;
	int y;

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

class Segment {
	int x1;
	int x2;
	int y;
	boolean lower;

	Segment(int a, int b, int c, boolean low) {
		x1 = a;
		x2 = b;
		y = c;
		lower = low;
	}
}

class Rectangle {
	Point upperLeft;
	Point bottomRight;

	Rectangle(Point a, Point b) {
		upperLeft = a;
		bottomRight = b;
	}
}

// Count the overall area that several rectangles occupy. O(N^2) with
// discretization.
// Could speed up to O(NlogN) by using segment tree
public class beta10_CountRectanglesArea {
	int countArea(Rectangle[] rect) {
		int n = rect.length;
		HashSet<Integer> xaxis = new HashSet<Integer>();
		Segment[] yset = new Segment[2 * n];
		int k = 0;
		// Discretization
		for (Rectangle r : rect) {
			xaxis.add(r.upperLeft.x);
			xaxis.add(r.bottomRight.x);
			yset[k] = new Segment(r.upperLeft.x, r.bottomRight.x,
					r.bottomRight.y, true);
			yset[k + 1] = new Segment(r.upperLeft.x, r.bottomRight.x,
					r.upperLeft.y, false);
			k += 2;
		}
		int[] xset = new int[xaxis.size()];
		k = 0;
		for (int i : xaxis) {
			xset[k++] = i;
		}
		Arrays.sort(xset);
		Arrays.sort(yset, new Comparator<Segment>() {
			public int compare(Segment a, Segment b) {
				return a.y > b.y ? 1 : -1;
			}
		});

		// Calculation
		int area = 0;
		for (int i = 0; i < xset.length - 1; i++) {
			int cnt = 0; // count horizontal margin
			int lowest = 0;
			for (int j = 0; j < 2 * n; j++) {
				if (yset[j].x1 <= xset[i] && yset[j].x2 >= xset[i + 1]) {
					if (cnt == 0)
						lowest = yset[j].y;
					cnt += (yset[j].lower ? 1 : -1);
					if (cnt == 0)
						area += (yset[j].y - lowest) * (xset[i + 1] - xset[i]);
				}
			}
		}
		return area;
	}

	// Test Case
	public static void main(String[] argv) {
		Rectangle[] rect = new Rectangle[4];
		rect[0] = new Rectangle(new Point(6, 1), new Point(7, 0));
		rect[1] = new Rectangle(new Point(0, 2), new Point(4, 0));
		rect[2] = new Rectangle(new Point(0, 5), new Point(2, 3));
		rect[3] = new Rectangle(new Point(1, 4), new Point(6, 1));
		System.out.println(new beta10_CountRectanglesArea().countArea(rect)); // 24
	}
}
