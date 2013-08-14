package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class n094_BinaryTreeInorderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> sta = new Stack<TreeNode>();
		while (root != null || sta.size() > 0) {
			while (root != null) {
				sta.push(root);
				root = root.left;
			}
			root = sta.pop();
			res.add(root.val); // 先序的话就把这句移到push前，后序的话需要增加flag表示当前节点是否访问了右子树
			root = root.right;
		}
		return res;
	}
}