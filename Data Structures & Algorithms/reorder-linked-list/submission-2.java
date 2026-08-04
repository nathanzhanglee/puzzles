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
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        } 
        ListNode dummy = new ListNode();
        while (head.next != null && prev.next != null) {
            dummy.next = head;
            dummy = dummy.next;
            head = head.next;
            dummy.next = prev;
            dummy = dummy.next;
            prev = prev.next;
        }
        if (head != null) {
            dummy.next = head;
        }
    }
}
