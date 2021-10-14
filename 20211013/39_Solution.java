//candidates = [2,3,5], target = 8
// 2, 3
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // I thought I had to sort the array but actually I don't
        // [2, 2, 3] or [3, 2, 2], they are the same, no need to sort 
        //Arrays.sort(candidates);
        backtracking(candidates, 0, target, res, new ArrayList<Integer>());
        return res;
    }
    
    private void backtracking(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                backtracking(candidates, i, target - candidates[i], res, list);
                list.remove(list.size() - 1);
            }  
        }
    }
}