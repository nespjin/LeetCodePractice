/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        return ans;
    }

    void traverse(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        traverse(root.left, ans);
        ans.add(root.val);
        traverse(root.right, ans);
    }
}
// @lc code=end
