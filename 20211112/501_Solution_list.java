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
	int cur = 1, max = 1;
	TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        List<Integer> max_nums = new ArrayList<Integer>();
        inOrder(root, max_nums);
        int[] ret = new int[max_nums.size()];
        int idx = 0;
        for (int num : max_nums) {
            ret[idx++] = num;
        }
        return ret;
    }

    private void inOrder(TreeNode node, List<Integer> max_nums) {
    	if (node == null) return;
    	inOrder(node.left, max_nums);

    	if (pre != null) {
    		if (pre.val == node.val) cur++;
    		else cur = 1;
    	}
    	if (cur > max) {
    		max = cur;
    		max_nums.clear();
    		max_nums.add(node.val);
    	} else if (cur == max) {
    		max_nums.add(node.val);
    	}
    	pre = node;

    	inOrder(node.right, max_nums);
    }
}