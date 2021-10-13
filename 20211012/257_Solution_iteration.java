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
        List<String> res = new ArrayList<String>(0);
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<String> pathStack = new Stack<String>();
        nodeStack.push(root);
        pathStack.push(Integer.toString(root.val));
        while (!nodeStack.isEmpty() && !pathStack.isEmpty()) {
        	TreeNode node = nodeStack.pop();
        	String path = pathStack.pop();
        	if (node == null) continue;
        	if (node.left == null && node.right == null) {
        		res.add(path);
        	}
        	if (node.left != null) {
        		nodeStack.add(node.left);
        		pathStack.add(path + "->" + Integer.toString(node.left.val));
        	}
        	if (node.right != null) {
        		nodeStack.add(node.right);
        		pathStack.add(path + "->" + Integer.toString(node.right.val));
        	}
        }

        return res;
    }
}