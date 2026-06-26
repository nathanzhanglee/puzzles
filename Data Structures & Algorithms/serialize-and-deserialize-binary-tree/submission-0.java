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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    s.append("" + node.val + "#");
                    q.add(node.left);
                    q.add(node.right);
                } else {
                    s.append("N");
                }
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        int i = 0;
        int rootVal = 0;
        while (data.charAt(i) != '#') {
            rootVal *= 10;
            rootVal += data.charAt(i) - '0';
            i++;
        }
        i++;
        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            TreeNode left = null;
            if (data.charAt(i) == 'N') {
                i++;
            } else {
                int leftVal = 0;
                while (data.charAt(i) != '#') {
                    leftVal *= 10;
                    leftVal += data.charAt(i) - '0';
                    i++;
                }
                i++;
                left = new TreeNode(leftVal);
                q.add(left);
            }
            curr.left = left;
            TreeNode right = null;
            if (data.charAt(i) == 'N') {
                i++;
            } else {
                int rightVal = 0;
                while (data.charAt(i) != '#') {
                    rightVal *= 10;
                    rightVal += data.charAt(i) - '0';
                    i++;
                }
                i++;
                right = new TreeNode(rightVal);
                q.add(right);
            }
            curr.right = right;
        }
        return root;
    }
}
