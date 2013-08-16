package LeetCode;

public class n122_BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = prices.length;
		if (n <= 1)
			return 0;
		int res = 0;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1]) {
				res += prices[i] - prices[i - 1];
			}
		}
		return res;
	}
}
