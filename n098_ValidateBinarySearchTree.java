package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class n098_ValidateBinarySearchTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;
		Stack<TreeNode> sta = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		while (root != null || sta.size() > 0) {
			while (root != null) {
				sta.push(root);
				root = root.left;
			}
			root = sta.pop();
			res.add(root.val);
			root = root.right;
		}
		for (int i = 1; i < res.size(); i++) {
			if (res.get(i) <= res.get(i - 1))
				return false;
		}
		return true;
	}
}
