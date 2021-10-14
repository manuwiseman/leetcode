class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(n, k, 1, res, new ArrayList<Integer>());
        return res;
    }

    private void backtracking(int n, int k, int start, List<List<Integer>> res, List<Integer> list) {
    	if (k == 0) {
    		res.add(new ArrayList<Integer>(list));
    		return;
    	}
    	for (int i = start; i <= n; i++) {
    		list.add(i);
    		backtracking(n, k - 1, i + 1, res, list);
    		list.remove(list.size() - 1);
    	}
    }
}