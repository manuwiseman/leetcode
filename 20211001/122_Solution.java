class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, res = 0;
        for (int i = 1; i < n; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                res += profit;
            }
        }
        return res;
    }
}