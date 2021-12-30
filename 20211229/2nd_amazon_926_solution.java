// 010110
// i = 3 -> p[i] + (n - i - p[n] + p[i])


class Solution {
    public int minFlipsMonoIncr(String s) {
        int ans = Integer.MAX_VALUE, n = s.length();
        // array to track # of 1 appears until index i
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + (s.charAt(i) == '0' ? 0 : 1);
        }
        
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, (p[i] + n - i - p[n] + p[i]));
        }
        
        return ans;
    }
}