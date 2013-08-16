package LeetCode;

import java.util.ArrayList;

public class n096_UniqueBinarySearchTreesII {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public ArrayList<TreeNode> subGen(int l, int r) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (l > r) {
			res.add(null);
			return res;
		}
		for (int i = l; i <= r; i++) {
			ArrayList<TreeNode> leftArr = subGen(l, i - 1); // 左子树的所有可能
			ArrayList<TreeNode> rightArr = subGen(i + 1, r); // 右子树的所有可能
			for (int p = 0; p < leftArr.size(); p++) { // 枚举组合
				for (int q = 0; q < rightArr.size(); q++) {
					TreeNode root = new TreeNode(i);
					root.left = leftArr.get(p);
					root.right = rightArr.get(q);
					res.add(root);
				}
			}
		}
		return res;
	}

	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return subGen(1, n);
	}
}
