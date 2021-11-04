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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd_pointer = head, even_pointer = head.next, even_head = even_pointer;
        
        while (even_pointer != null && even_pointer.next != null) {
            odd_pointer.next = odd_pointer.next.next;
            even_pointer.next = even_pointer.next.next;
            odd_pointer = odd_pointer.next;
            even_pointer = even_pointer.next;
        }
        odd_pointer.next = even_head;
        return head;
    }
}