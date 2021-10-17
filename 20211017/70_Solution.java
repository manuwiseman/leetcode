// class Solution {
//     public int climbStairs(int n) {
//         if (n < 2) return n;
        
//         int[] dp = new int[n + 1];
//         dp[0] = dp[1] = 1;
        
        
//         for (int i = 2; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp [i - 2];
//         }
        
//         return dp[n];
//     }
// }


class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;
        
        int pre1 = 1, pre2 = 1;
        
        
        for (int i = 2; i <= n; i++) {
            int cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        
        return pre2;
    }
}