package LeetCode;

public class n112_PathSum {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true; // 成功条件
		return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right,
				sum - root.val));
	}
}