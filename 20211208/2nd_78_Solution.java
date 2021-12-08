class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int size = 0; size <= nums.length; size++) {
            backtracking(ans, nums, size, 0, new ArrayList<Integer>());
        }
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, int[] nums, int size, int start, List<Integer> list) {
        if (list.size() == size)
        ans.add(new ArrayList<Integer>(list));
        
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(ans, nums, size, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}