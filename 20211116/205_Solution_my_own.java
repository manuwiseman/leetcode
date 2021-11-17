class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] s2t = new int[256], t2s = new int[256];
        Arrays.fill(s2t, -1);
        Arrays.fill(t2s, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (s2t[ss]  == -1 && t2s[tt] == -1) {
                s2t[ss] = tt;
                t2s[tt] = ss;
            } else {
                if (s2t[ss] != tt || t2s[tt] != ss) return false;
            }
        }
        
        return true;
    }
}