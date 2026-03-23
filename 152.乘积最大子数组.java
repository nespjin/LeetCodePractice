/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        long minF = nums[0];
        long maxF = nums[0];
        int ans = nums[0];
        final int len = nums.length;
        for (int i = 1; i < len; ++i) {
            long max = maxF, min = minF;
            maxF = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            minF = Math.min(max * nums[i], Math.min(min * nums[i], nums[i]));
            if (minF < (-1 << 31)) {
                minF = nums[i];
            }
            ans = ans > maxF ? ans : (int) maxF;
        }
        return ans;
    }
}
// @lc code=end
