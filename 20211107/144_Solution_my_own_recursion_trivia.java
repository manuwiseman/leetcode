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
    List<Integer> ans;
    public List<Integer> preorderTraversal(TreeNode root) {
        this.ans = new ArrayList<Integer>();
        if (root == null) return this.ans; 
        dfs(root);
        
        return this.ans;
    }
    
    private void dfs(TreeNode node) {
        if (node == null) return;
        this.ans.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}