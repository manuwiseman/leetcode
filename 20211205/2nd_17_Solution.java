class Solution {
    private static final String[] KEYS = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return ans;
        doCombination(new StringBuilder(), digits, ans);
        return ans;
    }
    
    private void doCombination(StringBuilder sb, String digits, List<String> ans) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int digit = digits.charAt(sb.length()) - '0';
        for (char c : KEYS[digit].toCharArray()) {
            sb.append(c);
            doCombination(sb, digits, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}