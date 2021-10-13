class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] visited){
        if (list.size() == nums.length && !res.contains(list)) res.add(new ArrayList<Integer>(list));
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backtracking(res, nums, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}