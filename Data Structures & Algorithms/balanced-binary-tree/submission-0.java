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
    public boolean isBalanced(TreeNode root) {
        return helper(root)[0] == 1;
    }
    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {1, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        boolean balanced = (left[0] == 1 && right[0] == 1) && (Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);
        return new int[] {balanced == true ? 1 : 0, height};
    }
}
