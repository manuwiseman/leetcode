class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtracking(ans, k, n, 1, new ArrayList<Integer>());
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, int k, int n, int start, List<Integer> list) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (k == 0 || n == 0) return;
        
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtracking(ans, k - 1, n - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}