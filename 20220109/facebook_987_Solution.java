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
class Triplet<F, S, T> {
    F first;
    S second;
    T third;
    
    public Triplet(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    List<Triplet<Integer, Integer, Integer>> list = new ArrayList<Triplet<Integer, Integer, Integer>> ();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        bfs(root);
        
        // sort based on (from 1 to 3): 1. column 2. row 3. value
        Collections.sort(list, new Comparator<Triplet<Integer, Integer, Integer>>(){
            @Override
            public int compare(Triplet<Integer, Integer, Integer> t1, Triplet<Integer, Integer, Integer> t2) {
                if (t1.first.equals(t2.first)) {
                    if (t1.second.equals(t2.second)) {
                        return t1.third - t2.third;
                    } else {
                        return t1.second - t2.second;
                    }
                } else {
                    return t1.first - t2.first;
                }
            }
        });
        
        int columnIdx = list.get(0).first;
        List<Integer> columnIdxList = new ArrayList<Integer>();
        for (Triplet<Integer, Integer, Integer> triplet : list) {
            if (triplet.first.equals(columnIdx)) {
                columnIdxList.add(triplet.third);
            } else {
                ans.add(columnIdxList);
                columnIdxList = new ArrayList<Integer>();
                columnIdxList.add(triplet.third);
                columnIdx = triplet.first;
            }
        }
        ans.add(columnIdxList);
        return ans;
    }

    private void bfs(TreeNode root) {
        Queue<Triplet<TreeNode, Integer, Integer>> q = new LinkedList<Triplet<TreeNode, Integer, Integer>>();
        q.add(new Triplet<TreeNode, Integer, Integer>(root, 0, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Triplet<TreeNode, Integer, Integer> triplet = q.poll();
                TreeNode node = triplet.first;
                int row = triplet.second;
                int col = triplet.third;
                list.add(new Triplet<Integer, Integer, Integer>(col, row, node.val));
                if (node.left != null) {
                    q.add(new Triplet<TreeNode, Integer, Integer>(node.left, row + 1, col - 1));
                }
                if (node.right != null) {
                    q.add(new Triplet<TreeNode, Integer, Integer>(node.right, row + 1, col + 1));
                }
            }
        }
    }
}