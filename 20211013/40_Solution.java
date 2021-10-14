class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // I need to sort it this time
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, res, new ArrayList<Integer>(), new boolean[candidates.length]);
        return res;
    }
    
    private void backtracking(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i != 0 && candidates[i - 1] == candidates[i] && 
                !visited[i - 1]) continue;
            if (candidates[i] <= target && !visited[i]) {
                list.add(candidates[i]);
                visited[i] = true;
                backtracking(candidates, i + 1, target - candidates[i], 
                             res, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }  
        }
    }
}