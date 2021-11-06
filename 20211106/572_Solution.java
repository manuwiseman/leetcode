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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isEqual(TreeNode l1, TreeNode l2) {
        if (l1 == null && l2 == null) return true;
        if (l1 == null || l2 == null) return false;
        if (l1.val != l2.val) return false;
        return isEqual(l1.left, l2.left) && isEqual(l1.right, l2.right);
    }
}