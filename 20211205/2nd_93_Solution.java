class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) return ans;
        backtracking(new StringBuilder(), s, ans, 0);
        return ans;
    }
    
    private void backtracking(StringBuilder sb, String s, List<String> ans, int k) {
        if (k == 4 && s.length() == 0) {
            ans.add(sb.toString());
            return;
        }
        
        for (int i = 0; i <=2 && i < s.length(); i++) {
            if (i != 0 && s.charAt(0) == '0') break;
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) > 255) continue;
            if (sb.length() != 0) {
                part = "." + part;
            }
            sb.append(part);
            backtracking(sb, s.substring(i + 1), ans, k + 1);
            sb.delete(sb.length() - part.length(), sb.length());
        }
    }
}