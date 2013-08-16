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
			lr[i] = Math.max(lr[i - 1], prices[i] - min); // 与第一题不同，这里每个位置都要记录置，所以干脆省掉判断prices[i]>min的判断。
		}
		int res = lr[n - 1]; // 初始化二次交易最大收益为单次交易的最大收益
		int max = prices[n - 1];
		int rl = 0;
		for (int i = n - 2; i >= 1; i--) {
			if (prices[i] > max) { // rl 不用每个位置都记录下来，所以采用和第一题一样的策略
				max = prices[i];
			} else {
				rl = Math.max(rl, max - prices[i]);
				res = Math.max(res, rl + lr[i - 1]);
			}
		}
		return res;
	}
}
