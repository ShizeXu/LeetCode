package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// Trie
class TreeNode {
	char ch;
	HashMap<Character, TreeNode> child;
	boolean isWord;

	TreeNode(char ch) {
		this.ch = ch;
		child = new HashMap<Character, TreeNode>();
		isWord = false;
	}

	void addWord(String word) {
		if (word.equals("")) {
			isWord = true;
			return;
		}
		char x = word.charAt(0);
		if (!child.containsKey(x)) {
			TreeNode node = new TreeNode(x);
			child.put(x, node);
		}
		child.get(x).addWord(word.substring(1));
	}

	TreeNode getChild(char x) {
		return child.get(x);
	}

	boolean hasChild(char x) {
		return child.containsKey(x);
	}

	boolean isWord() {
		return isWord;
	}
}

// Search words that in a dictionary
public class beta01_SearchManyWords {
	static int[][] d = { { -1, -1 },
			{ -1, 0 },
			{ -1, 1 },
			{ 0, 1 },
			{ 1, 1 },
			{ 1, 0 },
			{ 1, -1 },
			{ 0, -1 }, };

	HashSet<String> findWord(char[][] matrix, HashSet<String> dict) {
		TreeNode root = new TreeNode((char) 0);
		for (String s : dict)
			root.addWord(s.trim());
		HashSet<String> res = new HashSet<String>();
		boolean[][] flag = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (root.hasChild(matrix[i][j])) {
					for (boolean[] tmp : flag)
						Arrays.fill(tmp, false);
					res.addAll(find(matrix, flag, i, j,
							new StringBuilder().append(matrix[i][j]),
							root.getChild(matrix[i][j])));
				}
			}
		}
		return res;
	}

	HashSet<String> find(char[][] matrix, boolean[][] flag, int x, int y,
			StringBuilder sb, TreeNode root) {
		HashSet<String> res = new HashSet<String>();
		if (root.isWord()) {
			res.add(sb.toString());
		}
		for (int k = 0; k < 8; k++) {
			int i = x + d[k][0];
			int j = y + d[k][1];
			if (isValid(matrix, i, j) && root.hasChild(matrix[i][j])
					&& !flag[i][j]) {
				flag[i][j] = true;
				sb.append(matrix[i][j]);
				res.addAll(find(matrix, flag, i, j, sb,
						root.getChild(matrix[i][j])));
				sb.deleteCharAt(sb.length() - 1);
				flag[i][j] = false;
			}
		}
		return res;
	}

	boolean isValid(char[][] matrix, int x, int y) {
		return (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length);
	}
}
