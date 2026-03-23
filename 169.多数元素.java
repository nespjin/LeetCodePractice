/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int cadidate = 0;
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (count == 0) {
                cadidate = nums[i];
            }
            count += cadidate == nums[i] ? 1 : -1;
        }
        return cadidate;
    }
}
// @lc code=end
