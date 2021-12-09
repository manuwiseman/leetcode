class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        backtracking(s, ans, new ArrayList<String>());
        return ans;
    }
    
    private void backtracking(String s, List<List<String>> ans, List<String> list) {
        if (s.length() == 0) {
            ans.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                list.add(s.substring(0, i + 1));
                backtracking(s.substring(i + 1), ans, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) return false;
        }
        return true;
    }
}