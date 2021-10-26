class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        
        int left_min = prices[0];
        int right_max = prices[n - 1];

        int[] left = new int[n];
        int[] right = new int[n + 1];

        for (int i = 1; i < n; i++) {
        	left[i] = Math.max(left[i - 1], prices[i] - left_min);
            left_min = Math.min(left_min, prices[i]);

        	int r = n - i - 1;
            right[r] = Math.max(right[r + 1], right_max - prices[r]); 
        	right_max = Math.max(right_max, prices[r]);
        	
        }

        int max_profit = 0;
        for (int i = 0; i < n; i++) {
        	max_profit = Math.max(max_profit, left[i] + right[i + 1]);
        }

        return max_profit;
    }
}