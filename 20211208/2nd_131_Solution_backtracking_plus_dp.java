class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        backtracking(s, 0, ans, new ArrayList<String>(), dp);
        return ans;
    }
    
    private void backtracking(String s, int start, List<List<String>> ans, List<String> list, boolean[][] dp) {
        if (start == s.length()) {
            ans.add(new ArrayList<String>(list));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                list.add(s.substring(start, end + 1));
                backtracking(s, end + 1, ans, list, dp);
                list.remove(list.size() - 1);
            }
        }
    }
}