class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        backtracking(res, s, new StringBuilder(), 0);
        return res;
    }
    
    private void backtracking(List<String> res, String s, StringBuilder sb, int k) {
        if (k == 4 && s.length() == 0) {
            res.add(sb.toString());
            return;
        }
        
        for (int i = 0; i <= 2 && i < s.length(); i++) {
            if (i != 0 && s.charAt(0) == '0') break;
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) > 255) continue;
            if (sb.length() != 0) {
                part = "." + part;
            }
            sb.append(part);
            backtracking(res, s.substring(i + 1), sb, k + 1);
            sb.delete(sb.length() - part.length(), sb.length());
        }
    }
}