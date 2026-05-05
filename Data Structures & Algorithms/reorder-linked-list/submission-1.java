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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = null;
        ListNode next = slow;

        while (next != null) {
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr;
        }

        prev = head;
        while (curr.next != null) {
            ListNode temp = prev.next;
            prev.next = curr;
            prev = temp;
            temp = curr.next;
            curr.next = prev;
            curr = temp;
        }
    }
}
