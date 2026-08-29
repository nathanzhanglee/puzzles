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
    public int maxPathSum(TreeNode root) {
        return dfs(root)[1];
    }
    
    public int[] dfs(TreeNode curr) {
        if (curr == null) {
            return new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
        }
        int[] left = dfs(curr.left);
        int[] right = dfs(curr.right);
        int leftHeightSum = Math.max(left[0], 0);
        int rightHeightSum = Math.max(right[0], 0);
        int maxHeightPath = Math.max(leftHeightSum, rightHeightSum) + curr.val;
        int maxPath = Math.max(leftHeightSum + rightHeightSum + curr.val, Math.max(left[1], right[1]));
        return new int[] {maxHeightPath, maxPath};
    }
}
