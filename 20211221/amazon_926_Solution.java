class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] p = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + (s.charAt(i) == '0' ? 0 : 1);
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, p[i] + n - i - p[n] + p[i]);
        }
        return ans;
    }
}