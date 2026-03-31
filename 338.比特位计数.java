/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        final int[] bits = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
// @lc code=end
