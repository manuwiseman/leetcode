/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        inOrder(list, root);
        int l = 0, r = list.size() - 1;
        while (l < r) {
        	int sum = list.get(l) + list.get(r);
        	if (sum == k) {
        		return true;
        	} else if (sum < k) {
        		l++;
        	} else {
        		r--;
        	}
        }
        return false;
    }

    private void inOrder(List<Integer> list, TreeNode root) {
    	if (root == null) return;
    	inOrder(list, root.left);
    	list.add(root.val);
    	inOrder(list, root.right);
    }
}