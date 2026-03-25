/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        final int n = s.length();
        int ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2;
            int r = l + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
// @lc code=end
