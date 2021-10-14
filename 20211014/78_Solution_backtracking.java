//nums = [1,2,3]
// 0 elemnt: k = 0
// 1 element: k = 1
// 2 elements: k = 2
// 3 elements: k = 3
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        for (int size = 0; size <= nums.length; size++) {
            backtracking(nums, res, size, 0, list);
        }
        return res;
    }
    
    private void backtracking(int[] nums, List<List<Integer>> res, int size, int start, List<Integer> list){
        if (list.size() == size) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                backtracking(nums, res, size, i + 1, list);
                list.remove(list.size() - 1);
        }
    }
}