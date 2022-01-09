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
    int low, high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        return dfs(root);
    }
    
    private int dfs(TreeNode node) {
        int ans = 0;
        if (node.val >= low && node.val <= high) {
            ans += node.val;
        }
        if (node.val > low && node.left != null) {
            ans += dfs(node.left);
        }
        if (node.val < high && node.right != null) {
            ans += dfs(node.right);
        }
        return ans;
    }
}