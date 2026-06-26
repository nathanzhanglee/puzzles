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
    int preindex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return builder(preorder, 0, preorder.length - 1);
    }
    public TreeNode builder(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int value = preorder[preindex];
        TreeNode root = new TreeNode(value);
        preindex++;
        int middle = map.get(value);
        root.left = builder(preorder, left, middle - 1);
        root.right = builder(preorder, middle + 1, right);
        return root;
    }
}
