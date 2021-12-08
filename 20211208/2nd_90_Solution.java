class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length; size++) {
            backtracking(ans, nums, 0, size, new boolean[nums.length], new ArrayList<Integer>());
        }     
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, int[] nums, int start, int size, boolean[] visited, List<Integer> list) {
        if (list.size() == size) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            backtracking(ans, nums, i + 1, size, visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}