package LeetCode;

public class n054_JumpGame {
	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int far = 0;
		for (int i = 0; i < n - 1; i++) {
			if (i <= far) { // �ýڵ��ܵ���
				if (i + A[i] > far) {
					far = i + A[i];
				}
			} else { // �ýڵ㲻�ɵ���
				break;
			}
		}
		return (far >= n - 1);
	}
}