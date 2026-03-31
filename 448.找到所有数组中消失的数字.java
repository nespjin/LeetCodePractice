/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; ++i) {
            final int x = (nums[i] - 1) % n;
            if (nums[x] <= n) {
                nums[x] += n;
            }
        }
        final List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
// @lc code=end
