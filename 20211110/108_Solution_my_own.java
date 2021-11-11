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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }
    
    private TreeNode dfs(int start, int end, int[] nums) {
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (start <= mid - 1) node.left = dfs(start, mid - 1, nums);
        if (end >= mid + 1) node.right = dfs(mid + 1, end, nums);
        return node;
    }
}