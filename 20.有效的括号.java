/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        final int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        final Map<Character, Character> pairs = new LinkedHashMap<>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            final char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
