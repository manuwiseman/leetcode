class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtracking(ans, 1, n, k, new ArrayList<Integer>());
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, int start, int n, int k, List<Integer> list) {
        if (k == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i<= n; i++) {
            list.add(i);
            backtracking(ans, i + 1, n, k - 1, list);
            list.remove(list.size() - 1);
        }
    }
}