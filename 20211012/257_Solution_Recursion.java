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
    	constructPath(res, "", root);
    	return res;
    }

    private void constructPath(List<String> res, String path, TreeNode node) {
    	if (node != null) {
    		path += Integer.toString(node.val);
    		if (node.left == null && node.right == null) {
    			res.add(path);
    		} else {
    			path += "->";
    			constructPath(res, path, node.left);
    			constructPath(res, path, node.right);
    		}
    	}
    }
}