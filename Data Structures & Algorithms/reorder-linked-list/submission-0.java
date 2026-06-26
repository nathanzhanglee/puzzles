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
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        int i = 0;
        curr = head;
        while (i < len / 2) {
            curr = curr.next;
            i++;
        } 
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr = head;
        while (curr != null && curr.next != null) {
            if (prev == null) {
                break;
            }
            ListNode originalNext = curr.next;
            curr.next = prev;
            prev = prev.next;
            curr.next.next = originalNext;
            curr = curr.next.next;
        }
        curr.next = null;
    }
}
