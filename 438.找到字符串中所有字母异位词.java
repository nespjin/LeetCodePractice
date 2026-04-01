/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final int sLen = s.length();
        final int pLen = p.length();
        final List<Integer> ans = new ArrayList<>();
        if (pLen > sLen)
            return ans;
        final int[] sCount = new int[26];
        final int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(pCount, sCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
// @lc code=end
