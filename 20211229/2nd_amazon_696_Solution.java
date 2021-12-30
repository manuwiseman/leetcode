// 00110011
//2, 2, 2, 2
// 001100(pre)11(cur)
class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0, pre = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        
        return ans + Math.min(pre, cur);
    }
}