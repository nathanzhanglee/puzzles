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
    public void reorderList(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
       }
       ListNode prev = null;
       ListNode curr = slow;
       while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
       }
       while (prev.next != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = prev.next;
            head.next.next = next;
            head = next;
       }
    }
}
