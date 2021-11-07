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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sum(root.left, true) + sum(root.right, false);
    }
    
    private int sum(TreeNode node, boolean isLeftNode) {
        if (node == null) return 0;
        int addition = isLeftNode && node.left == null && node.right == null ? node.val : 0;
        return addition + sum(node.left, true) + sum(node.right, false);
    }
}