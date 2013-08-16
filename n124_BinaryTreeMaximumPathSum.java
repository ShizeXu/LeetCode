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

	public int max;

	public int sum(TreeNode root) {
		if (root == null)
			return 0;
		int maxL = sum(root.left);
		int maxR = sum(root.right);
		int tmpMax = root.val + Math.max(maxL, maxR);
		tmpMax = Math.max(tmpMax, root.val); // 经过当前元素的最大值
		max = Math.max(max, tmpMax);
		max = Math.max(max, root.val + maxL + maxR); // 不经过的最大值
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
