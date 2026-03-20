/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        final int rows = matrix.length;
        final int columns = matrix[0].length;
        if (columns == 0) {
            return 0;
        }
        final int[][] dp = new int[rows][columns];
        int maxSide = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (matrix[i][j] != '1') {
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
// @lc code=end
