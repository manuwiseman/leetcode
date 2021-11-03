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
        ListNode m1 = l1, m2 = l2;
        int n1 = 0, n2 = 0;

        while (m1 != null) {
        	m1 = m1.next;
        	n1++;
        }

        while (m2 != null) {
        	m2 = m2.next;
        	n2++;
        }

        m1 = l1;
        m2 = l2;
        ListNode head = null;

        while (n1 > 0 || n2 > 0){
            int val = 0;
        	if (n1 >= n2) {
        		val += m1.val;
        		m1 = m1.next;
        		n1--;
        	}
        	if (n1 < n2) {
        		val += m2.val;
        		m2 = m2.next;
        		n2--;
        	}

        	ListNode node = new ListNode(val);
        	node.next = head;
        	head = node;
    	}

    	int carry = 0;
    	m1 = head;
    	head = null;

    	while (m1 != null) {
    		carry += m1.val;
    		ListNode node = new ListNode(carry % 10);
    		node.next = head;
    		head = node;
    		m1 = m1.next;
    		carry /= 10;
    	}
        
        if (carry != 0) {
            ListNode node = new ListNode(carry % 10);
    		node.next = head;
    		head = node;
        }

    	return head;
	}
}