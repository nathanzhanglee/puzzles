/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = dfs(root);
        return result[0];
    }
    public int[] dfs(TreeNode curr) {
        if (curr == null) {
            return new int[] {0, 0};
        }
        int[] left = dfs(curr.left);
        int[] right = dfs(curr.right);
        int height = Math.max(left[1], right[1]) + 1;
        int maxPath = Math.max(Math.max(left[0], right[0]), right[1] + left[1]);
        return new int[] {maxPath, height};
    }
}
