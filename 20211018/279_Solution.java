class Solution {
    public int numSquares(int n) {
        if (n == 1) return 1;
        int max_sqrt = (int) Math.sqrt(n);
        int[] squares = new int[max_sqrt + 1];
        for (int i = 1; i <= max_sqrt; i++) {
            squares[i] = i * i;
        }
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= max_sqrt; j++){
                if (i < squares[j]) break;
                dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
            }
        }
        
        return dp[n];
    }
}