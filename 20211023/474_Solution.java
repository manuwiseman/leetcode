class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
        	int zeros = 0, ones = 0;
        	for (int i = 0; i < str.length(); i++) {
        		if (str.charAt(i) == '0') {
        			zeros++;
        		} else {
        			ones++;
        		}	
        	}

        	for (int x = m; x >= zeros; x--) {
        		for (int y = n; y >= ones; y--) {
        			dp[x][y] = Math.max(dp[x][y], dp[x - zeros][y - ones] + 1);
        		}
        	}
        }

        return dp[m][n];
    }
}