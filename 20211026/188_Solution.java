class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int max_profit = 0;

        if (k == 0 || n == 0) {
        	return 0;
        }

        // for any prices[i] > prices[i - 1]
        // we add to result
        if (2 * k >= n) {
        	for (int i = 1; i < n; i++) {
        		if (prices[i] > prices[i - 1]) {
        			max_profit += prices[i] - prices[i - 1];
        		}
        	}
        	return max_profit;
        }

        int[][][] dp = new int[n][k + 1][2];

        // initialize array with -inf
        // use -1e9 to prevent overflow
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j <= k; j++) {
        		dp[i][j][0] = -1000000000;
        		dp[i][j][1] = -1000000000;
        	}
        }

        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < n; i++) {
        	for (int j = 0; j <= k; j++) {
        		dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
        		if (j > 0) {
        			dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
        		}
        	}
        }

        for (int i = 0; i <= k; i++) {
        	max_profit = Math.max(max_profit, dp[n - 1][i][0]);
        }

        return max_profit;
    }
}