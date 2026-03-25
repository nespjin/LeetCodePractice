/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        final Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int ans = 0;
        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                int curr = num;
                int consecutive = 1;
                while (numsSet.contains(curr + 1)) {
                    ++curr;
                    ++consecutive;
                }
                ans = consecutive > ans ? consecutive : ans;
            }
        }
        return ans;
    }
}
// @lc code=end
