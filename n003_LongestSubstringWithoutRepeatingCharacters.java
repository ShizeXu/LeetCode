package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class n003_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Map<Character, Integer> mymap = new HashMap<Character, Integer>();
		int max = 0;
		int pre = -1;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char a = s.charAt(i);
			if (mymap.containsKey(a) && mymap.get(a) > pre) {
				int tmp = i - pre - 1;
				if (tmp > max) {
					max = tmp;
				}
				pre = mymap.get(a);
			}
			mymap.put(a, i);
		}
		int tmp = n - pre - 1;
		if (tmp > max) {
			max = tmp;
		}
		return max;
	}
}