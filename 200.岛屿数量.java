/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    static class UnionFinder {
        private int count;
        private int[] parent;
        private int[] rank;

        UnionFinder(char[][] grid) {
            count = 0;
            final int rows = grid.length;
            final int cols = grid[0].length;
            parent = new int[rows * cols];
            rank = new int[rows * cols];
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * cols + j] = i * cols + j;
                        ++count;
                    }
                    rank[i * cols + j] = 0;
                }
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            final int rootX = find(x);
            final int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    ++rank[rootX];
                }
                --count;
            }
        }

        int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        UnionFinder unionFind = new UnionFinder(grid);
        final int rows = grid.length;
        final int cols = grid[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * cols + j, (i - 1) * cols + j);
                    }
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        unionFind.union(i * cols + j, (i + 1) * cols + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * cols + j, i * cols + (j - 1));
                    }
                    if (j + 1 < cols && grid[i][j + 1] == '1') {
                        unionFind.union(i * cols + j, i * cols + (j + 1));
                    }
                }
            }
        }
        return unionFind.getCount();
    }
}
// @lc code=end
