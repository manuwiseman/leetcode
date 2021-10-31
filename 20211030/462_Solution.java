class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, count = 0;
        
        while (l < r) {
            count += nums[r--] - nums[l++];
        }
        
        return count;
    }
}