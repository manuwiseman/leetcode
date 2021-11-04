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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode p = head;
        int size = 0;
        
        // get size of linked list
        while (p != null) {
            p = p.next;
            size++;
        }
        
        p = head;
        int index = 0;
        while (p != null) {
            // length of each part
            int len = size % k == 0 ? size / k : size / k + 1;
            size -= len;
            k--;
            while (len > 1) {
                p = p.next;
                len--;
            }
            ListNode last = p;
            p = p.next;
            last.next = null;
            ans[index++] = head;
            head = p;
        }
        
        return ans;
    }
}