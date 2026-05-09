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
        if (lists.length == 0)  return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode res = new ListNode(0);
        ListNode curr = res;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            node = node.next;
            if (node != null) {
                minHeap.offer(node);
            }
        }

        return res.next;
    }
}

// [[1,2,4],[1,3,5],[3,6]]

// 1 1 3

// 1.next 2 push
// 1 pop

// 1 -> null
// // 2nd pass
// 1 2 3

// 1.next 3 push
// 1.pop

// 1 -> 1 -> null