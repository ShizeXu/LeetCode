package LeetCode;

public class n124_BinaryTreeMaximumPathSum {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 用全局变量或Pair类
	public int max;

	public int sum(TreeNode root) {
		if (root == null)
			return 0;
		int maxL = sum(root.left);
		int maxR = sum(root.right);
		int tmpMax = Math.max(root.val + Math.max(maxL, maxR), root.val); // 经过当前元素继续往上走
		max = Math.max(max, tmpMax);
		max = Math.max(max, root.val + maxL + maxR); // max{不可扩展路径,可往上扩展的路径,原始值}
		return tmpMax;
	}

	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		max = Integer.MIN_VALUE;
		sum(root);
		return max;
	}
}
