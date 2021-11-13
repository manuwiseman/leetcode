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
//[1, 2, 2, 3, 3, 3, 4] [(1, 1), (2, 2), (3, 3), (4, 1)]
class Solution {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int[] findMode(TreeNode root) {
        // populate the map
        inorder(root);
        // find the mode(s)
        int maxVal = Collections.max(map.values());
        List<Integer> ans = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxVal) {
                ans.add(entry.getKey());
            }
        }
        
        return ans.stream().mapToInt(i->i).toArray();
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        this.map.put(node.val, this.map.getOrDefault(node.val, 0) + 1);
        inorder(node.right);
    }
}