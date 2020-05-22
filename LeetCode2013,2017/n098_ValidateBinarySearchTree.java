package LeetCode;

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
		int pre = Integer.MIN_VALUE;
		while (root != null || sta.size() > 0) {
			while (root != null) {
				sta.push(root);
				root = root.left;
			}
			root = sta.pop();
			if (root.val <= pre)
				return false;
			pre = root.val;
			root = root.right;
		}
		return true;
	}
}
