class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (seen[nums[i]]) {
                ans[0] = nums[i];
            } else {
                seen[nums[i]] = true;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                ans[1] = i;
                break;
            }
            
        }
        return ans;
    }
}