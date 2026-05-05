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
        ListNode prev = null;
        ListNode curr = null;
        ListNode next = head;

        while (next != null) {
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr;
        }
        return curr;
    }
}
