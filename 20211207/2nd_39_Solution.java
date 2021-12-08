class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtracking(ans, candidates, 0, target, new ArrayList<Integer>());
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, int[] candidates, int start, int target, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            list.add(candidates[i]);
            backtracking(ans, candidates, i, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}