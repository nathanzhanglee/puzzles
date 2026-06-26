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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = myQueue.poll();
                layer.add(node.val);
                if (node.left != null) {
                    myQueue.add(node.left);
                }
                if (node.right != null) {
                    myQueue.add(node.right);
                }
            }
            res.add(layer);
        }
        return res;
    }
}
