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
    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, ListNode[]> map = new HashMap<>();
        for (int i = -1000; i <= 1000; i++) {
            map.put(i, new ListNode[2]);
        }

        for (ListNode list : lists) {
            ListNode curr = list;
            while (curr != null) {
                ListNode[] tmp = map.get(curr.val);
                if (tmp[0] == null) {
                    tmp[0] = curr;
                    tmp[1] = curr;
                } else {
                    tmp[1].next = curr;
                    tmp[1] = tmp[1].next;
                }
                map.put(curr.val, tmp);
                curr = curr.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        for (int i = -1000; i <= 1000; i++) {
            if (map.get(i)[0] == null) continue;
            ListNode[] tmp = map.get(i);
            ans.next = tmp[0];
            ans = tmp[1];
        }

        return dummy.next;
    }
}
