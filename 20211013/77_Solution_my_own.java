class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(n, k, new boolean[n + 1], new ArrayList<Integer>(), res);
        return res;
    }
    
    private void backtracking(int n, int k, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) res.add(new ArrayList<Integer>(list));
        for (int i = 1; i <= n; i++) {
            // only ascending order
            if (list.size() > 0 && list.get(list.size() - 1) > i) continue;
            if (!visited[i]) {
                list.add(i);
                visited[i] = true;
                backtracking(n, k, visited, list, res);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}