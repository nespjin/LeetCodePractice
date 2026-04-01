/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        backstrace(nums, target, 0, 0);
        return count;
    }

    void backstrace(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target)
                ++count;
        } else {
            backstrace(nums, target, index + 1, sum + nums[index]);
            backstrace(nums, target, index + 1, sum - nums[index]);
        }
    }
}
// @lc code=end
