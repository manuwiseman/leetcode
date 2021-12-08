class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtracking(ans, candidates, target, 0, new boolean[candidates.length], new ArrayList<Integer>());
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, int[] candidates, int target, int start, boolean[] visited, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i != 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) continue;
            list.add(candidates[i]);
            visited[i] = true;
            backtracking(ans, candidates, target - candidates[i], i + 1, visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}