class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int max = 1;

        for (int j = 1; j < n; j++) {
        	for (int i = 0; i < j; i++) {
        		if (pairs[j][0] > pairs[i][1]) {
        			dp[j] = Math.max(dp[j], dp[i] + 1);
        		}
        	}
        	max = Math.max(max, dp[j]);
        }

        return max;
    }
}