class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtracking(ans, nums, new ArrayList<Integer>());
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtracking(ans, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}