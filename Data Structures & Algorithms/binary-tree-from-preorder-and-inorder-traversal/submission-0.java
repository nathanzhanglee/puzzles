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
    int preindex;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preindex = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return builder(preorder, 0, inorder.length - 1);
    }

    public TreeNode builder(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = map.get(preorder[preindex]);
        TreeNode root = new TreeNode(preorder[preindex]);
        preindex++;
        root.left = builder(preorder, left, middle - 1);
        root.right = builder(preorder, middle + 1, right);
        return root;
    }
}
