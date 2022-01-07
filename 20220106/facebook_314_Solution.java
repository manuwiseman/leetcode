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
// number of node on level = Math.pow(2, level), and level start from 0
// 1 + 2 + 4 + 8 + 16 + 32 + 64, we have at most 7 levels
// 0
// -1, 1
// -2, 0, 0, 2
// -3, -1, -1, 1, -1, 1, 1, 3
// -4, -2, -2, 0
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        // key is position, and value is node
        Queue<Pair<Integer, TreeNode>> q = new LinkedList<Pair<Integer, TreeNode>>();
        q.add(new Pair<Integer, TreeNode>(0, root));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<Integer, TreeNode> pair = q.poll();
                int key = pair.getKey();
                TreeNode node = pair.getValue();
                map.putIfAbsent(key, new ArrayList<Integer>());
                map.get(key).add(node.val);
                if (node.left != null) q.add(new Pair<Integer, TreeNode>(key - 1, node.left));
                if (node.right != null) q.add(new Pair<Integer, TreeNode>(key + 1, node.right));
            }
        }
        
        return new ArrayList<List<Integer>>(map.values());
    }
}