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
    int preIndex = 0;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        root.left = helper(preorder, 0, map.get(root.val) - 1);
        root.right = helper(preorder, map.get(root.val) + 1, preorder.length - 1);
        return root;
    }
    public TreeNode helper(int[] preorder, int lower, int upper) {
        if (lower > upper) {
            return null;
        }
        TreeNode curr = new TreeNode(preorder[preIndex]);
        preIndex++;
        curr.left = helper(preorder, lower, map.get(curr.val) - 1);
        curr.right = helper(preorder, map.get(curr.val) + 1, upper);
        return curr;
    }
}
