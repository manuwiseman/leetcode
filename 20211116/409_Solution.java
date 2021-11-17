class Solution {
    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        int ans = 0;
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        
        for (int cnt : cnts) {
            ans += (cnt / 2) * 2;
        }
        
        return ans < s.length() ? ans + 1 : ans;
    }
}