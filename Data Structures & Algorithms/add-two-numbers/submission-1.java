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
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        ListNode curr = l1;
        while (curr != null) {
            num1.append("" + curr.val);
            curr = curr.next;
        }
        curr = l2;
        while (curr != null) {
            num2.append("" + curr.val);
            curr = curr.next;
        }
        String sum = "" + (Integer.parseInt(num1.reverse().toString()) + Integer.parseInt(num2.reverse().toString()));
        int index = sum.length() - 1;
        ListNode dummy = new ListNode();
        curr = dummy;
        while (index >= 0) {
            curr.next = new ListNode(sum.charAt(index) - '0');
            curr = curr.next;
            index--;
        }
        return dummy.next;
    }
}
