class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(k, n, 1, res, new ArrayList<Integer>());
        return res;
    }
    
    private void backtracking(int k, int n, int start,
                              List<List<Integer>> res, List<Integer> list) {
        if (n == 0 && list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (list.size() < k && i <= n) {
                list.add(i);
                backtracking(k, n - i, i + 1, res, list);
                list.remove(list.size() - 1);
            }    
        }
    }
}