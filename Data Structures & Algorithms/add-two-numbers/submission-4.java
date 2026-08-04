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
        int first = 0;
        int second = 0;
        int place = 1;
        ListNode curr = l1;
        while (l1 != null) {
            first += l1.val * place;
            place *= 10;
            curr = curr.next;
            l1 = l1.next;
        }
        curr = l2;
        place = 1;
        while (l2 != null) {
            second += l2.val * place;
            place *= 10;
            curr = curr.next;
            l2 = l2.next;
        }
        ListNode dummy = new ListNode();
        curr = dummy;
        String number = "" + (first + second);
        int length = number.length();
        for (int i = 0; i < length; i++) {
            curr.next = new ListNode(number.charAt(length - 1 - i) - '0');
            curr = curr.next;
        }
        return dummy.next;
    }
}
