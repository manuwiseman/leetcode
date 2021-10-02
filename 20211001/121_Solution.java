class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minValue = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }
        
        return dp[dp.length - 1];
    }
}