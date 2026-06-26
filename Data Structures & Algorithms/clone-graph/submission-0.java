/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> m = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        m.put(node, new Node(node.val));
        q.add(node); 
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                Node clone = m.get(n);
                for (Node neighbor : n.neighbors) {
                    if (!m.containsKey(neighbor)) {
                        m.put(neighbor, new Node(neighbor.val));
                        q.add(neighbor);
                    };
                    clone.neighbors.add(m.get(neighbor));
                }
            }
        }
        return m.get(node);
    }
}