package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class n050_NQueens {
	// Recursive solution
	public void subSolve(ArrayList<String[]> resArr, int[] res, int n, int x) {
		if (x > n - 1) { // DONE
			String[] tmp = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					sb.append(j == res[i] ? 'Q' : '.');
				}
				tmp[i] = sb.toString();
			}
			resArr.add(tmp);
			return;
		}

		for (int i = 0; i < n; i++) {
			boolean flag = true;
			int j = 0;
			// CHECK
			for (j = 0; j < x; j++) {
				if (res[j] == i || Math.abs(res[j] - i) == Math.abs(j - x)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				res[x] = i;
				subSolve(resArr, res, n, x + 1);
				res[x] = -1; // 可有可无，因为不会影响到后续子问题
			}
		}
	}

	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> resArr = new ArrayList<String[]>();
		int[] res = new int[n];
		if (n < 1)
			return resArr;
		subSolve(resArr, res, n, 0);
		return resArr;
	}

	// Non-recursive solution
	public ArrayList<String[]> solveNQueensNew(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = new int[n];
		ArrayList<String[]> resArr = new ArrayList<String[]>();
		Arrays.fill(res, -1);
		int i = 0, j = 0;
		while (i >= 0) { // the ith row
			for (j = res[i] + 1; j < n; j++) { // the jth column
				if (valid(res, i, j)) {
					res[i] = j;
					break;
				}
			}
			if (j == n)
				res[i--] = -1; // fail, back trace
			else {
				if (i == n - 1) {
					resArr.add(print(res));
					res[i--] = -1;
				} else {
					i++;
				}
			}
		}
		return resArr;
	}

	boolean valid(int[] res, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (res[k] == j || Math.abs(res[k] - j) == (i - k))
				return false;
		}
		return true;
	}

	String[] print(int[] res) {
		StringBuilder sb = new StringBuilder();
		String[] str = new String[res.length];
		for (int i = 0; i < res.length; i++)
			sb.append('.');
		for (int i = 0; i < res.length; i++) {
			sb.setCharAt(res[i], 'Q');
			str[i] = sb.toString();
			sb.setCharAt(res[i], '.');
		}
		return str;
	}

	public static void main(String[] argv) {
		n050_NQueens nq = new n050_NQueens();
		ArrayList<String[]> res = nq.solveNQueensNew(4);
		for (String[] str : res) {
			for (String s : str) {
				System.out.println(s);
			}
			System.out.println();
		}
	}
}
