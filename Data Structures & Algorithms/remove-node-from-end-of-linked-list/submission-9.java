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
        ListNode p1 = head;
        ListNode p2 = head;

        while (n > 0) {
            p1 = p1.next;
            n--;
        }

        if (p1 == null) return head.next;

        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        p2.next = p2.next.next;

        return head;
    }
}

// 1 2 3 4 5 6     n = 2
//       a2   p1
//       while (p.next != null)
//         a.next = a.next.next


// 1 2
// p1