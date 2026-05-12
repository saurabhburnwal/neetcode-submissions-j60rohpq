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
        ListNode curr = head.next;

        int i = 0;
        while (i < k && curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }

        if (i < k) {
            curr = prev;
            prev = null;

            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            return prev;
        }

        head.next.next = curr;
        curr = head.next;
        head.next = prev;
        curr.next = rev(curr, k);
        return prev;
    }
}

// null  1 2 3  4 5 6  1 2 3  4 5 6
//  p    c
//       3 2 1  4
//           p  c

