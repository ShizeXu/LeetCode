package LeetCode;

import java.util.ArrayList;

public class n111_MinimumDepthofBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
		if (root == null)
			return 0;
		int begin = 0;
		tmp.add(root);
		int depth = 1;
		int end = 1;
		while (true) {
			for (int i = begin; i < end; i++) {
				TreeNode tmpNode = tmp.get(i);
				if (tmpNode.left == null && tmpNode.right == null)
					return depth;
				if (tmpNode.left != null) {
					tmp.add(tmpNode.left);
				}
				if (tmpNode.right != null) {
					tmp.add(tmpNode.right);
				}
			}
			depth++;
			begin = end;
			end = tmp.size();
		}
	}
}
