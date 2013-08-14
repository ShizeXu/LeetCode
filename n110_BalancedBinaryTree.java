package LeetCode;

public class n110_BalancedBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Pair {
		boolean flag = false; // �Ƿ�ƽ��
		int depth = 0; // ���ĸ߶�

		Pair(boolean f, int d) {
			flag = f;
			depth = d;
		}
	}

	public Pair is(TreeNode root) {
		if (root == null)
			return new Pair(true, 0);
		Pair left = is(root.left);
		Pair right = is(root.right);
		if (!left.flag || !right.flag)
			return new Pair(false, 0); // ������ƽ��
		int max = Math.max(left.depth, right.depth);
		int min = Math.min(left.depth, right.depth);
		if (max - min > 1)
			return new Pair(false, 0); // ��ǰ����ƽ��
		return new Pair(true, max + 1);
	}

	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Pair res = is(root);
		return res.flag;
	}
}