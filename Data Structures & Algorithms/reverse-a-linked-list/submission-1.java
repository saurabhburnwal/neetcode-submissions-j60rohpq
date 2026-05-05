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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;
    }
}

// h
// 1 -> 2 -> 3 -> null

// rL(1->2->3->null)
// newhead = 3
// head.next.next = head
// 2 -> 1
// 1.next = null

// rL(2->3->null)
// newhead = 3
// head.next.next = head
// 3.next = 2

// rL(3->null)
//     nh = 3
//     3.next = null
//     return 3

// 3 -> 2 -> 1 -> null

// 3