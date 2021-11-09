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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || cur != null) {
        	while (cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	TreeNode node = stack.pop();
        	ans.add(node.val);
        	cur = node.right;
        }

        return ans;
    }
}