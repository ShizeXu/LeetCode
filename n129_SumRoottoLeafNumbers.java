package LeetCode;

import java.util.ArrayList;

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
		ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
		tmp.add(root);
		int res = 0;
		int begin = 0, end = 1;
		while (begin < end) {
			for (int i = begin; i < end; i++) {
				TreeNode tmpNode = tmp.get(i);
				if (tmpNode.left == null && tmpNode.right == null) { // ����Ҷ�ڵ㣬����sum
					res += tmpNode.val;
					continue;
				}
				if (tmpNode.left != null) { // ��10���ۼӵ����ӽ��
					tmpNode.left.val = tmpNode.left.val + 10 * tmpNode.val;
					tmp.add(tmpNode.left);
				}
				if (tmpNode.right != null) { // ��10���ۼӵ����ӽ��
					tmpNode.right.val = tmpNode.right.val + 10 * tmpNode.val;
					tmp.add(tmpNode.right);
				}
			}
			begin = end;
			end = tmp.size();
		}
		return res;
	}
}