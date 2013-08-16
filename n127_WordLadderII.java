package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class n127_WordLadderII {
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<String>> resArr = new ArrayList<ArrayList<String>>();
		Queue<ArrayList<String>> pre = new LinkedList<ArrayList<String>>();
		int m = start.length();
		ArrayList<String> res = new ArrayList<String>();
		if (start.equals(end)) {
			res.add(start);
			resArr.add(res);
			return resArr;
		}
		int n = dict.size();
		if (n == 0)
			return resArr;
		HashSet<String> toDel = new HashSet<String>();
		res.add(start);
		pre.offer((ArrayList<String>) res.clone());

		// dict.remove(start);

		while (pre.size() > 0) {
			toDel.clear();
			int presize = pre.size();
			for (int k = 0; k < presize; k++) {
				res = pre.poll();
				StringBuffer sb = new StringBuffer(res.get(res.size() - 1));
				for (int i = 0; i < m; i++) {
					char x = sb.charAt(i);
					for (char j = 'a'; j <= 'z'; j++) {
						if (j == x)
							continue;
						sb.setCharAt(i, j);
						String str = sb.toString();
						if (str.equals(end)) {
							res.add(str);
							resArr.add((ArrayList<String>) res.clone());
							res.remove(res.size() - 1);
						} else if (dict.contains(str)) {
							toDel.add(str);
							res.add(str);
							pre.offer((ArrayList<String>) res.clone());
							res.remove(res.size() - 1);
						}
						sb.setCharAt(i, x);
					}
				}
			}
			if (resArr.size() > 0)
				return resArr;
			for (String s : toDel)
				dict.remove(s);
		}
		return resArr;
	}
}
