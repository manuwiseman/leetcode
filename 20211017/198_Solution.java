//nums = [8,2,3,1]
// dp[2] = dp[0] + 3 = 4
// dp[3] = dp[1] + 
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        //int[] dp = new int[n];
        int pre1 = nums[0];
        int pre2 = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            int cur = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = cur;
        }
        
        return pre2;
    }
}