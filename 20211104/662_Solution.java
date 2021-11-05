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
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<TreeNode>(). new ArrayList<TreeNode>());
    }

    private int dfs(TreeNode node, int level, int index, List<TreeNode> start, List<TreeNode> end) {
    	if (node == null) return 0;
    	if (start.size() == level) {
    		start.add(index);
    		end.add(index);
    	} else {
    		end.set(level, index);
    	}
		
		int current = end.get(level) - start.get(level) + 1;
		int left = dfs(root.left, level + 1, index * 2, start, end);
		int right = dfs(root.right, level + 1, index * 2 + 1, start, end);
		return Math.max(current, Math.max(left, right));
    }
}