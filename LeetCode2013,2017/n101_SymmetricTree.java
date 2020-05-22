package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class n101_SymmetricTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Non-recursively
	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;
		Queue<TreeNode> p = new LinkedList<TreeNode>(); // 可用stack替换
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		p.offer(root.left);
		q.offer(root.right);
		while (p.size() > 0) {
			TreeNode tmpp = p.poll();
			TreeNode tmpq = q.poll();
			if (tmpp == null && tmpq == null)
				continue;
			if (tmpp == null || tmpq == null)
				return false;
			if (tmpp.val != tmpq.val)
				return false;
			// 注意对称性
			p.offer(tmpp.left);
			q.offer(tmpq.right);
			p.offer(tmpp.right);
			q.offer(tmpq.left);
		}
		return true;
	}
}
