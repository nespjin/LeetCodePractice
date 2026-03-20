/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    char[] visited;
    boolean canFinish = true;
    List<List<Integer>> edges;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }

        edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        visited = new char[numCourses];

        for (int[] item : prerequisites) {
            edges.get(item[1]).add(item[0]);
        }

        for (int i = 0; i < numCourses && canFinish; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        return canFinish;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (int e : edges.get(i)) {
            if (visited[e] == 0) {
                dfs(e);
                if (!canFinish)
                    return;
            } else if (visited[e] == 1) {
                canFinish = false;
                return;
            }
        }
        visited[i] = 2;
    }
}
// @lc code=end
