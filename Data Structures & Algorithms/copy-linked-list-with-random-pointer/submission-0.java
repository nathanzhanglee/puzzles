/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        HashMap<Node, Node> m = new HashMap<>();
        while (curr != null) {
            m.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node currCopy = m.get(curr);
            currCopy.next = m.get(curr.next);
            currCopy.random = m.get(curr.random);
            curr = curr.next;
        }
        return m.get(head);
    }
}
