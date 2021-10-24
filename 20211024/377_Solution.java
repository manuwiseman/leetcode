class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp[target] is what we finally will return;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i - num];
            }
        }
        
        return dp[target];
    }
}