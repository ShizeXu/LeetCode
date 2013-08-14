package LeetCode;

import java.util.ArrayList;

public class n113_PathSumII {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void sum(ArrayList<ArrayList<Integer>> resArr,
			ArrayList<Integer> res, TreeNode root, int sum) {
		if (root == null)
			return;
		if (root.left == null && root.right == null && root.val == sum) { // �ɹ�����
			res.add(root.val);
			resArr.add((ArrayList<Integer>) res.clone());
			res.remove(res.size() - 1); // �ǵ�
			return;
		}
		res.add(root.val);
		sum(resArr, res, root.left, sum - root.val); // ��������
		sum(resArr, res, root.right, sum - root.val); // ��������
		res.remove(res.size() - 1);
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		sum(resArr, res, root, sum);
		return resArr;
	}
}