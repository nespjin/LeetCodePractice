/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // int ans = 0;
        // for (final int num : nums) {
        // ans ^= num;
        // }
        // return ans;
        int ans = nums[0];
        final int len = nums.length;
        for (int i = 1; i < len; ++i) {
            ans ^= nums[i];
        }
        return ans;
    }
}
// @lc code=end
