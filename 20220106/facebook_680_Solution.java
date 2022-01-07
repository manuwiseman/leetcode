class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isTotalValidPalindrome(s.substring(left, right)) || isTotalValidPalindrome(s.substring(left + 1, right + 1));
            }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isTotalValidPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}