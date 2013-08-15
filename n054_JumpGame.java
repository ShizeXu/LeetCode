package LeetCode;

public class n054_JumpGame {
	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int far = 0;
		for (int i = 0; i < n; i++) {
			if (i <= far) { // 该节点能到达
				far = Math.max(i + A[i], far);
				if (far >= n - 1)
					return true;
			} else { // 该节点不可到达
				break;
			}
		}
		return false;
	}
}