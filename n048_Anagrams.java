package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class n048_Anagrams {
	public String hashFunc(String s) { // 重组字符
		ArrayList<Character> arr = new ArrayList<Character>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			arr.add(s.charAt(i));
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr.get(i));
		}
		return sb.toString(); // 接受空串
	}

	public ArrayList<String> anagrams(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		int n = strs.length;
		ArrayList<String> res = new ArrayList<String>();
		if (n < 2)
			return res;
		for (int i = 0; i < n; i++) {
			String tmp = hashFunc(strs[i]);
			if (map.containsKey(tmp)) {
				map.get(tmp).add(i);
			} else {
				ArrayList<Integer> tmpArr = new ArrayList<Integer>();
				tmpArr.add(i);
				map.put(tmp, tmpArr);
			}
		}
		ArrayList<Integer> tmpArr = new ArrayList<Integer>();
		for (String tmp : map.keySet()) {
			tmpArr = map.get(tmp);
			int size = tmpArr.size();
			if (size > 1) {
				for (int j = 0; j < size; j++)
					res.add(strs[tmpArr.get(j)]);
			}
		}
		return res;
	}
}