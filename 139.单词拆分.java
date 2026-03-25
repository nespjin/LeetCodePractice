/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final int n = s.length();
        int maxWordLen = 0;
        for (String word : wordDict) {
            maxWordLen = Math.max(word.length(), maxWordLen);
        }
        final Set<String> words = new HashSet<String>(wordDict);
        final boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            final int start = Math.max(0, i - maxWordLen);
            for (int j = start; j < i; ++j) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end
