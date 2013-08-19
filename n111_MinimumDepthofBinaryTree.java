package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

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
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null)
			return 0;
		q.offer(root);
		int depth = 1;
		while (true) {
			int n = q.size();
			while ((n--) > 0) {
				TreeNode tmpNode = q.poll();
				if (tmpNode.left == null && tmpNode.right == null)
					return depth;
				if (tmpNode.left != null) {
					q.offer(tmpNode.left);
				}
				if (tmpNode.right != null) {
					q.offer(tmpNode.right);
				}
			}
			depth++;
		}
	}
}
