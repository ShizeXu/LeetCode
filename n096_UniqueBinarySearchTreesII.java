package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

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

	// 改为dp好了，应该能快一点
	public ArrayList<TreeNode> subGen(int l, int r,
			HashMap<String, ArrayList<TreeNode>> dp) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (l > r) {
			res.add(null);
			return res;
		}
		String str = String.valueOf(l) + "_" + String.valueOf(r);
		if (dp.containsKey(str))
			return dp.get(str);
		for (int i = l; i <= r; i++) {
			ArrayList<TreeNode> leftArr = subGen(l, i - 1, dp); // 左子树的所有可能
			ArrayList<TreeNode> rightArr = subGen(i + 1, r, dp); // 右子树的所有可能
			for (int p = 0; p < leftArr.size(); p++) { // 枚举组合
				for (int q = 0; q < rightArr.size(); q++) {
					TreeNode root = new TreeNode(i);
					root.left = leftArr.get(p);
					root.right = rightArr.get(q);
					res.add(root);
				}
			}
		}
		dp.put(str, res);
		return res;
	}

	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<String, ArrayList<TreeNode>> dp = new HashMap<String, ArrayList<TreeNode>>();
		return subGen(1, n, dp);
	}
}
