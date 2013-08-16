package LeetCode;

import java.util.ArrayList;

public class n056_InsertInterval {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Interval> res = new ArrayList<Interval>();
		int n = intervals.size();
		int i = 0;
		// 第一步，找到左端点
		while (i < n && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i));
			i++;
		}
		if (i == n) {
			intervals.add(newInterval);
			return intervals;
		}
		int tmpL = intervals.get(i).start;
		int l = Math.min(tmpL, newInterval.start);
		// 第二步，找到右端点
		while (i < n && intervals.get(i).end <= newInterval.end) {
			i++;
		}
		if (i == n) {
			res.add(new Interval(l, newInterval.end));
			return res;
		}
		tmpL = intervals.get(i).start;
		if (tmpL > newInterval.end) {
			res.add(new Interval(l, newInterval.end));
		} else {
			res.add(new Interval(l, intervals.get(i).end));
			i++;
		}
		// 第三步，把剩下的加入结果集
		while (i < n) {
			res.add(intervals.get(i++));
		}
		return res;
	}
}
