package LeetCode;

public class n108_ConvertSortedArraytoBinarySearchTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode build(int[] num, int begin, int end) {
		if (begin > end)
			return null;
		int i = (end + begin + 1) / 2; // È·¶¨¸ù
		TreeNode root = new TreeNode(num[i]);
		root.left = build(num, begin, i - 1);
		root.right = build(num, i + 1, end);
		return root;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = num.length;
		return build(num, 0, n - 1);
	}
}