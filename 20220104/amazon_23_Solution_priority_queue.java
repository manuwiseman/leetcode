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
        if (lists == null || lists.length == 0) return null;
        ListNode p = new ListNode(-1), root = p;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            p.next = new ListNode(poll.val, null);
            p = p.next;
            if (poll.next != null) pq.add(poll.next);
        }
        
        return root.next;
    }
}