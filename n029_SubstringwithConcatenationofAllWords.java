package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class n029_SubstringwithConcatenationofAllWords {
	public boolean subFind(HashMap<String, Integer> dictSubStr, int m,
			int perLen, String S, int si, String[] L) {
		// check the end point
		if (0 == m)
			return true;
		String tmpStr = S.substring(si, si + perLen);
		if (dictSubStr.containsKey(tmpStr) && dictSubStr.get(tmpStr) > 0) {
			dictSubStr.put(tmpStr, dictSubStr.get(tmpStr) - 1);
			if (subFind(dictSubStr, m - 1, perLen, S, si + perLen, L)) {
				dictSubStr.put(tmpStr, dictSubStr.get(tmpStr) + 1);
				m++;
				return true;
			}
			dictSubStr.put(tmpStr, dictSubStr.get(tmpStr) + 1);
			m++;
		}
		return false;
	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = S.length();
		int m = L.length;
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n == 0 || m == 0)
			return res;
		int perLen = L[0].length();
		int length = 0;
		length = perLen * m;
		if (length > n)
			return res;
		// Calculate the index dictionary for each word in L
		HashMap<String, Integer> dictSubStr = new HashMap<String, Integer>();
		for (int i = 0; i < m; i++) {
			// Filter the same subString
			if (dictSubStr.containsKey(L[i])) {
				dictSubStr.put(L[i], dictSubStr.get(L[i]) + 1);
				continue;
			}
			dictSubStr.put(L[i], 1);
		}
		// 都不用DP...真伤心...
		for (int i = 0; i <= n - length; i++) {
			if (subFind(dictSubStr, m, perLen, S.substring(i, i + length), 0, L)) { // 只传部分字串能优化效率
				res.add(i);
			}
		}
		return res;
	}
}