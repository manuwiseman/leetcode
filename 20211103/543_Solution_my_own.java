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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        maxHeight(root);
        return max;
    }
    
    private int maxHeight(TreeNode root) {
        if (root == null) return 0;
        int l = maxHeight(root.left);
        int r = maxHeight(root.right);
        max = Math.max(max, l + r);
        return 1 + Math.max(l, r);
    } 
}