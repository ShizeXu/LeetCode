package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

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
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int depth = 0;
		while (!q.isEmpty()) {
			int n = q.size();
			while ((n--) > 0) {
				TreeNode tmpNode = q.poll();
				if (tmpNode.left != null)
					q.offer(tmpNode.left);
				if (tmpNode.right != null)
					q.offer(tmpNode.right);
			}
			depth++;
		}
		return depth;
	}
}
