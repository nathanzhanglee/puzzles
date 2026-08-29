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
    int result = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return result;
        }
        result++;
        helper(root.left, root.val);
        helper(root.right, root.val);
        return result;
    }
    public void helper(TreeNode curr, int max) {
        if (curr == null) {
            return;
        }
        if (curr.val >= max) {
            result++;
        }
        helper(curr.left, Math.max(curr.val, max));
        helper(curr.right, Math.max(curr.val, max));
    }
}
