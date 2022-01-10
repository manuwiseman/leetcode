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
// thoughts: for each level, we need to show the rightmost node
// use BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            // for each level we only want to insert at most one node into ans list
            int size = q.size();
            level++;
            while (size-- > 0) {
                TreeNode node = q.poll();
                // e.g. on 2nd row, if we already have 2 nodes in ans, we don't need to add until next row
                if (ans.size() < level) ans.add(node.val);
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
        }
        return ans;
    }
}