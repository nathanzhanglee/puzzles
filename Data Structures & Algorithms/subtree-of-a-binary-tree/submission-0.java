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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<TreeNode> firsts = new ArrayList<>();
        dfs(root, subRoot.val, firsts);
        for (TreeNode node : firsts) {
            if (isCopy(node, subRoot)) {
                return true;
            }
        }
        return false;
    }

    public void dfs(TreeNode root, int val, List<TreeNode> firsts) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            firsts.add(root);
        }
        dfs(root.left, val, firsts);
        dfs(root.right, val, firsts);
    }

    public boolean isCopy(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if (root == null || subroot == null || root.val != subroot.val) {
            return false;
        }
        return isCopy(root.left, subroot.left) && isCopy(root.right, subroot.right);
    }
}
