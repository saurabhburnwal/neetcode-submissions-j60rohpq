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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            curr = curr.next;
            len++;
        }

        int new_n = len - n;

        if (new_n == 0) return head.next;

        curr = head;
        while (new_n > 1) {
            curr = curr.next;
            new_n--;
        }

        if (curr.next != null) curr.next = curr.next.next;

        return head;
    }
}
