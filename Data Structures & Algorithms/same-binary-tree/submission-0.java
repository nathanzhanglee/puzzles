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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> m = new LinkedList<>();
        Queue<TreeNode> n = new LinkedList<>();
        m.add(p);
        n.add(q);
        while (!m.isEmpty() && !n.isEmpty()) {
            if (m.size() != n.size()) {
                return false;
            }
            int size = n.size();
            for (int i = 0; i < size; i++) {
                TreeNode pCurr = m.poll();
                TreeNode qCurr = n.poll();
                if ((qCurr == null && pCurr != null) || (pCurr == null && qCurr != null)) {
                    return false;
                } else if (qCurr == null) {
                    continue;
                } else {
                    if (qCurr.val != pCurr.val) {
                        return false;
                    }
                    m.add(qCurr.left);
                    m.add(qCurr.right);
                    n.add(pCurr.left);
                    n.add(pCurr.right);
                }
            }
        }
        if (!m.isEmpty() || !n.isEmpty()) {
            return false;
        }
        return true;
    }
}
