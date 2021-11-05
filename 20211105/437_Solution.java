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
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int k, count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0);
        return this.count;
    }

    private void preorder(TreeNode node, int sum) {
    	if (node == null) return;
    	int curSum = sum + node.val;
    	// situation 1: from root to current node, sum is targetSum
    	if (curSum == this.k) this.count++;

    	// situation 2: from non-root node current node, sum is targetSum
    	this.count += map.getOrDefault(curSum - k, 0);
    	map.put(curSum, map.getOrDefault(curSum, 0) + 1);
    	preorder(node.left, curSum);
    	preorder(node.right, curSum);
    	map.put(curSum, map.get(curSum) - 1);
    }
}