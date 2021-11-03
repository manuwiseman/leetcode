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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = toStack(l1);
        Stack<ListNode> s2 = toStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
        	int i1 = s1.isEmpty() ? 0 : s1.pop().val;
        	int i2 = s2.isEmpty() ? 0 : s2.pop().val;
        	carry = carry + i1 + i2;
        	ListNode node = new ListNode(carry % 10);
        	node.next = head.next;
        	head.next = node;
        	carry /= 10;
        }

        return head.next;
    }

    private Stack<ListNode> toStack(ListNode l) {
    	Stack<ListNode> stack = new Stack<ListNode>();
    	while (l != null) {
    		stack.push(l);
    		l = l.next;
    	}

    	return stack;
    }
}