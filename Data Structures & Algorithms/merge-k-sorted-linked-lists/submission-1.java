/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode l : lists) {
            pq.add(l);
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode smallest = pq.remove();
            curr.next = smallest;
            curr = curr.next;
            if (smallest.next != null) {
                pq.add(smallest.next);  
            }
        }
        return dummy.next;
    }
}
