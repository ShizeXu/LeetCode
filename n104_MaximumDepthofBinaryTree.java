package LeetCode;

import java.util.ArrayList;

public class n104_MaximumDepthofBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;
		ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
		tmp.add(root);
		int begin = 0, end = 1;
		int depth = 0;
		while (begin < end) {
			for (int i = begin; i < end; i++) {
				TreeNode tmpNode = tmp.get(i);
				if (tmpNode.left != null)
					tmp.add(tmpNode.left);
				if (tmpNode.right != null)
					tmp.add(tmpNode.right);
			}
			depth++;
			begin = end;
			end = tmp.size();
		}
		return depth;
	}
}
