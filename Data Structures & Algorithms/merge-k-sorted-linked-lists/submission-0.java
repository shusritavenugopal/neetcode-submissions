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
        ListNode result = new ListNode(0);
        ListNode pointer = result;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode list: lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode current = minHeap.remove(); // [1,2,4]
            pointer.next = current; // [0,1,2,4]
            pointer = pointer.next; // [1,2,4]

            if (pointer.next != null) { // [2,4]
                minHeap.add(pointer.next); // [1,3,5],[2,4],[3,6]
            }
        }

        return result.next;
    }
}
