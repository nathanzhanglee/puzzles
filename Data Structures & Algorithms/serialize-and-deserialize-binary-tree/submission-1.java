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
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    s.append("N,");
                } else {
                    s.append("" + curr.val + ",");
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes[0].equals("N")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;
        while (index < nodes.length) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (!nodes[index].equals("N")) {
                    curr.left = new TreeNode(Integer.parseInt(nodes[index]));
                    q.add(curr.left);
                }
                index++;
                if (!nodes[index].equals("N")) {
                    curr.right = new TreeNode(Integer.parseInt(nodes[index]));
                    q.add(curr.right);
                }
                index++;            
            }
        }
        return root;
    }
}
