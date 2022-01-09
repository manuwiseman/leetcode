/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// HashMap to store the current node and it's parent node
// stack for tree traversal
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
        parents.put(root, null);
        stack.push(root);
        
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parents.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                stack.push(node.right);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        while (p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }
        
        while (!ancestors.contains(q)) {
            q = parents.get(q);
        }
        
        return q;
    }
}