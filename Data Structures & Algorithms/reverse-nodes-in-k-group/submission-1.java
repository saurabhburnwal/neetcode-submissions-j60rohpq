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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        return rev(dummy, k);
    }

    public ListNode rev(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = null;
        ListNode next = head.next;

        int i = 0;
        while (i < k && next != null) {
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr;
            i++;
        }

        if (i < k) {
            next = curr;
            prev = null;
            curr = null;

            while (next != null) {
                curr = next;
                next = next.next;
                curr.next = prev;
                prev = curr;
            }

            return curr;
        }

        head.next.next = next;
        next = head.next;
        head.next = curr;
        next.next = rev(next, k);
        return curr;
    }
}
