// 2, 2, 3
// 2, 2, 3, x -> x = 0
// 2, 2, 3, x -> 3 * 10 + x > 26 || 2, 2, 0, x
class Solution {
    public int numDecodings(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
        	if (s.charAt(i - 1) != '0') {
        		dp[i] += dp[i - 1];
        	}
        	if (s.charAt(i - 2) != '0' && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
        		dp[i] += dp[i - 2];
        	}
        }

        return dp[n];
    }
}