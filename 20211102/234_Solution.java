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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }

        if (fast != null) {
        	slow = slow.next;
        }

        cutInHalf(head, slow);
        return isEqual(head, reverse(slow));
    }

    private void cutInHalf(ListNode head, ListNode cutNode) {
    	while (head.next != cutNode) {
    		head = head.next;
    	}
    	head.next = null;
    }

    private ListNode reverse(ListNode head) {
    	ListNode newHead = null;
    	while (head != null) {
    		ListNode temp = head.next;
            head.next = newHead;
    		newHead = head;
    		head = temp;
    	}

    	return newHead;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
    	while (l1 != null && l2 != null) {
    		if (l1.val != l2.val) return false;
    		l1 = l1.next;
    		l2 = l2.next;
    	}

    	return true;
    }
}