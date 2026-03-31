/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        final int max = amount + 1;
        final int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[max - 1] > amount ? -1 : dp[max - 1];
    }
}
// @lc code=end
