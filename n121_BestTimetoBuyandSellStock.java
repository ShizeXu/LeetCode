package LeetCode;

public class n121_BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int res = 0;
		int n = prices.length;
		if (n <= 1)
			return 0;
		int min = prices[0];
		for (int i = 1; i < n; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				res = Math.max(res, prices[i] - min);
			}
		}
		return res;
	}
}