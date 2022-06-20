// s and dicstionary only use lower english letter -> char[] size 26?
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String dict : dictionary) {
            int len1 = ans.length(), len2 = dict.length();
            if (len1 > len2 || (len1 == len2 && ans.compareTo(dict) < 0)) {
                continue;
            }    
            if (isSubstring(s, dict)) ans = dict;
        }
        
        return ans;
    }
    
    private boolean isSubstring(String s1, String s2) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < s1.length() && idx2 < s2.length()) {
            if (s1.charAt(idx1) == s2.charAt(idx2)) {
                idx2++;
            }
            idx1++;
        }
        return idx2 == s2.length();
    }
}