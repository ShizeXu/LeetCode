package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class n129_SumRoottoLeafNumbers {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int res = 0;
		while (!q.isEmpty()) {
			int n = q.size();
			while ((n--) > 0) {
				TreeNode tmpNode = q.poll();
				if (tmpNode.left == null && tmpNode.right == null) { // 遇到叶节点，更新结果
					res += tmpNode.val;
					continue;
				}
				if (tmpNode.left != null) { // 乘10后累加到左子结点
					tmpNode.left.val = tmpNode.left.val + 10 * tmpNode.val;
					q.offer(tmpNode.left);
				}
				if (tmpNode.right != null) { // 乘10后累加到右子结点
					tmpNode.right.val = tmpNode.right.val + 10 * tmpNode.val;
					q.offer(tmpNode.right);
				}
			}
		}
		return res;
	}
}
