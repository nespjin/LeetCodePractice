/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除了自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int[] answers = new int[nums.length];
        answers[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            answers[i] = answers[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = answers.length - 1; i >= 0; --i) {
            answers[i] = answers[i] * r;
            r *= nums[i];
        }
        return answers;
    }
}
// @lc code=end
