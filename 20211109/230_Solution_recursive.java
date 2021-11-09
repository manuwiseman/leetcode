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
    public int kthSmallest(TreeNode root, int k) {
         List<Integer> list = inorder(root, new ArrayList<Integer>());
         return list.get(k - 1);
    }

    private List<Integer> inorder(TreeNode node, List<Integer>  res) {
    	if (node == null) return res;
    	inorder(node.left, res);
    	res.add(node.val);
    	inorder(node.right, res);
    	return res;
    }
}