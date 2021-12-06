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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        backtracking(root, ans, "");
        return ans;
    }
    
    private void backtracking(TreeNode root, List<String> ans, String path) {
        if (root == null) return;
        path += String.valueOf(root.val);
        if (root != null && root.left == null && root.right == null) {
            ans.add(path);
            return;
        }
        
        path += "->";
        backtracking(root.left, ans, path);
        backtracking(root.right, ans, path);
    }
}