/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > ans) {
                ans = prices[i] - minPrice;
            }
        }
        return ans;
    }
}
// @lc code=end
