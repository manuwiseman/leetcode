// dp = [1, 1, 2, 6]
// rp = [24, 12, 4, 1]
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] rp = new int[n];
        int[] ans = new int[n];
        dp[0] = 1;
        rp[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] * nums[i - 1];
            rp[n - i - 1] = rp[n - i] * nums[n - i]; 
        }
        
        for (int i = 0; i < n; i++) {
            ans[i] = dp[i] * rp[i];
        }
        
        return ans;
    }
}