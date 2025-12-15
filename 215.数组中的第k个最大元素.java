/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] bucket = new int[20001];
        for (int i = 0; i < nums.length; ++i) {
            bucket[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; --i) {
            k = k - bucket[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }
}
// @lc code=end
