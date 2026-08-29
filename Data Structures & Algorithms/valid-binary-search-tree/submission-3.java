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
    public boolean isValidBST(TreeNode root) {
       if (root == null) {
        return true;
       } 
       return helper(root.left, Integer.MIN_VALUE, root.val) && helper(root.right, root.val, Integer.MAX_VALUE);

    }
    public boolean helper(TreeNode curr, int min, int max) {
        if (curr == null) {
            return true;
        }
        if (curr.val < max && curr.val > min) {
            return helper(curr.left, min, curr.val) && helper(curr.right, curr.val, max);
        }
        return false;
    }
}
