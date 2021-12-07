class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtracking(ans, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backtracking(ans, nums, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}`