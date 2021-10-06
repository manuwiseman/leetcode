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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new LinkedList<TreeNode>();
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int start, int end) {
    	List<TreeNode> list = new LinkedList<TreeNode>();
    	if (start > end) {
    		list.add(null);
    		return list;
    	}

    	for (int i = start; i <= end; i++) {
    		List<TreeNode> left = generateSubtrees(start, i - 1);
    		List<TreeNode> right = generateSubtrees(i + 1, end);
    		for (TreeNode l : left) {
    			for (TreeNode r : right) {
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				list.add(root);
    			}
    		}
    	}

    	return list;
    }
}