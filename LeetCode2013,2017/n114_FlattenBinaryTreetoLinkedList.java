package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class n114_FlattenBinaryTreetoLinkedList {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		Stack<TreeNode> sta = new Stack<TreeNode>();
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		while (root != null || sta.size() > 0) {
			while (root != null) {
				sta.push(root);
				res.add(root);
				root = root.left;
			}
			root = sta.pop();
			root = root.right;
		}
		res.add(null); // 方便起见
		for (int i = res.size() - 2; i >= 0; i--) {
			res.get(i).left = null;
			res.get(i).right = res.get(i + 1);
		}
	}
}
