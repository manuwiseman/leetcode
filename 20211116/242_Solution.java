class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alpha = new int[26];
        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            alpha[c - 'a']--;
            if (alpha[c - 'a'] < 0) return false;
        }

        return true;
    }
}