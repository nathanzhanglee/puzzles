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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (sum >= 10) {
                int remainder = sum % 10; // 0
                if (l1.next != null) {
                    l1.next.val = l1.next.val + 1;
                } else if (l2.next != null) {
                    l2.next.val = l2.next.val + 1;
                } else {
                    curr.next = new ListNode(remainder);
                    curr.next.next = new ListNode(1);
                    return dummy.next;
                }
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1.val >= 10) {
                curr.next = new ListNode(l1.val % 10);
                curr = curr.next;
                l1 = l1.next;
                if (l1 != null) {
                    l1.val += 1;
                } else {
                    l1 = new ListNode (1);
                }
            }
            curr.next = l1;
        } 
        if (l2 != null) {
            while (l2.val >= 10) {
                curr.next = new ListNode(l2.val % 10);
                curr = curr.next;
                l2 = l2.next;
                if (l2 != null) {
                    l2.val += 1;
                } else {
                    l2 = new ListNode (1);
                }                
            }
            curr.next = l2;
        } 
        return dummy.next;
    }
}
