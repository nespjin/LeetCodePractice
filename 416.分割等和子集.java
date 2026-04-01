/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        final int n = nums.length;
        int maxNum = 0;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (sum % 2 != 0) {
            return false;
        }
        final int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        final boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; ++i) {
            final int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
// @lc code=end
