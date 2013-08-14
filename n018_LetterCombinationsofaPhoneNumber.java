package LeetCode;

import java.util.ArrayList;

public class n018_LetterCombinationsofaPhoneNumber {

	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String>[] arr = new ArrayList[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = new ArrayList<String>();
		}
		arr[2].add("a");
		arr[2].add("b");
		arr[2].add("c");
		arr[3].add("d");
		arr[3].add("e");
		arr[3].add("f");
		arr[4].add("g");
		arr[4].add("h");
		arr[4].add("i");
		arr[5].add("j");
		arr[5].add("k");
		arr[5].add("l");
		arr[6].add("m");
		arr[6].add("n");
		arr[6].add("o");
		arr[7].add("p");
		arr[7].add("q");
		arr[7].add("r");
		arr[7].add("s");
		arr[8].add("t");
		arr[8].add("u");
		arr[8].add("v");
		arr[9].add("w");
		arr[9].add("x");
		arr[9].add("y");
		arr[9].add("z");
		arr[0].add(" ");

		return recurse(digits, arr);
	}

	public ArrayList<String> recurse(String digits, ArrayList<String>[] arr) {
		ArrayList<String> tmpArr = new ArrayList<String>();
		int n = digits.length();
		if (n == 0) {
			tmpArr.add("");
			return tmpArr;
		}
		int ind = digits.charAt(0) - 48;
		ArrayList<String> suf = recurse(digits.substring(1), arr);
		int m = suf.size();
		for (int i = 0; i < arr[ind].size(); i++) {
			for (int j = 0; j < m; j++) {
				tmpArr.add(arr[ind].get(i) + suf.get(j));
			}
		}
		return tmpArr;
	}
}