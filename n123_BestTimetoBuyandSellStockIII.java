package LeetCode;

public class n123_BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = prices.length;
		if (n <= 1)
			return 0;
		int min = prices[0];
		int[] lr = new int[n];
		for (int i = 1; i < n; i++) {
			min = Math.min(prices[i], min);
			lr[i] = Math.max(lr[i - 1], prices[i] - min); // ���һ�ⲻͬ������ÿ��λ�ö�Ҫ��¼�ã����Ըɴ�ʡ���ж�prices[i]>min���жϡ�
		}
		int res = lr[n - 1]; // ��ʼ�����ν����������Ϊ���ν��׵��������
		int max = prices[n - 1];
		int rl = 0;
		for (int i = n - 2; i >= 1; i--) {
			if (prices[i] > max) { // rl ����ÿ��λ�ö���¼���������Բ��ú͵�һ��һ���Ĳ���
				max = prices[i];
			} else {
				rl = Math.max(rl, max - prices[i]);
				res = Math.max(res, rl + lr[i - 1]);
			}
		}
		return res;
	}
}