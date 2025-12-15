/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] lastCharIndex = new int[256];
        for (int i = 0; i < 256; ++i) {
            lastCharIndex[i] = -1;
        }

        int n = s.length();
        int l = 0;
        int max = 0;

        for (int r = 0; r < n; ++r) {
            int c = s.charAt(r);
            l = lastCharIndex[c] + 1 > l ? lastCharIndex[c] + 1 : l;
            int len = r - l + 1;
            max = len > max ? len : max;
            lastCharIndex[c] = r;
        }
        return max;
    }
}
// @lc code=end

// import java.util.HashSet;
// import java.util.Set;

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }
//         int n = s.length();
//         int max = 0;
//         int l = 0;
//         int r = 0;
//         Set<Character> chars = new HashSet<Character>();

//         while (r < n) {
//             if (!chars.contains(s.charAt(r))) {
//                 chars.add(s.charAt(r));
//                 int len = r - l + 1;
//                 max = len > max ? len : max;
//                 ++r;
//             } else {
//                 chars.remove(s.charAt(l));
//                 ++l;
//             }
//         }
//         return max;
//     }
// }