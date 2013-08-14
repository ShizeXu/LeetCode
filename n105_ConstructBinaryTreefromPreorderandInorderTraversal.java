package LeetCode;

public class n105_ConstructBinaryTreefromPreorderandInorderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode findRoot(int[] preorder, int[] inorder, int p1, int p2,
			int i1, int i2) {
		if (p1 > p2)
			return null;
		TreeNode root = new TreeNode(preorder[p1]);
		if (p1 == p2)
			return root;
		int rootVal = preorder[p1];
		int i = i1;
		for (i = i1; i <= i2; i++) {
			if (inorder[i] == rootVal)
				break; // 找到根节点在中序中的位置 i
		}
		root.left = findRoot(preorder, inorder, p1 + 1, p1 + i - i1, i1, i - 1);
		root.right = findRoot(preorder, inorder, p2 - i2 + i + 1, p2, i + 1, i2);
		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = preorder.length;
		return findRoot(preorder, inorder, 0, n - 1, 0, n - 1);
	}
}