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
        List<String> res = new ArrayList<String>();
        List<Integer> values = new ArrayList<Integer>();
        backtracking(res, values, root);
        return res;
    }
    
    private void backtracking(List<String> res, List<Integer> values, TreeNode node) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        if (node != null && node.left == null && node.right == null) {
            res.add(buildPath(values));
        } else {
            backtracking(res, values, node.left);
            backtracking(res, values, node.right);
        }
        values.remove(values.size() - 1);
    }
    
    private String buildPath(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        for (int val : values) {
            if (sb.length() == 0) {
                sb.append(val);
            } else {
                sb.append("->" + val);
            }
        }
        return sb.toString();
    }
}