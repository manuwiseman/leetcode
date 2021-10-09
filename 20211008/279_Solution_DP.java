class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int max_sqrt = (int) Math.sqrt(n);
        int[] sqrt = new int[max_sqrt + 1];
        for (int i = 1; i <= max_sqrt; i++) {
        	sqrt[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= max_sqrt; j++) {
                if (i < sqrt[j]) break;
                dp[i] = Math.min(dp[i], dp[i - sqrt[j]] + 1);
        	}
        }

        return dp[n];
    }
}