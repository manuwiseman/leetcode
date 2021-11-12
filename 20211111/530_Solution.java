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
// class Solution {
//     int pre = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
//     public int getMinimumDifference(TreeNode root) {
//         inOrder(root);
//         return this.min;
//     }
    
//     private void inOrder(TreeNode node) {
//         if (node == null) return;
//         inOrder(node.left);
//         this.min = Math.min(this.min, Math.abs(node.val - this.pre));
//         this.pre = node.val;
//         inOrder(node.right);
//     }
// }

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
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return this.min;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (this.pre != null) this.min = Math.min(this.min, node.val - this.pre.val);
        this.pre = node;
        inOrder(node.right);
    }
}