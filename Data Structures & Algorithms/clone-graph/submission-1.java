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
        HashMap<Node, Node> map = new HashMap<>();
        Node copy = new Node(node.val);
        map.put(node, copy);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                Node currCopy = map.get(curr);
                for (Node neighbor : curr.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, new Node(neighbor.val));
                        q.add(neighbor);
                    }
                    currCopy.neighbors.add(map.get(neighbor));
                }
            }
        }
        return copy;
    }
}