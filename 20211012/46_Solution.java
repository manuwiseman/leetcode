class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, nums, new ArrayList<Integer>());
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) res.add(new ArrayList(list));
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtracking(res, nums, list);
                // list.remove(nums[i]) gives me out of bound exception, don't know why
                list.remove(list.size() - 1);
            }
        }
    }
}