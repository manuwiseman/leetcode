class Solution {
	private static final String[] KEYS = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<>();
    	if (digits == null || digits.length() == 0) return res;
    	doCombination(new StringBuilder(), digits, res);
    	return res;
    }

    private void doCombination(StringBuilder sb, String digits, List<String> res) {
    	if (sb.length() == digits.length()) {
    		res.add(sb.toString());
    		return;
    	}

    	int key = digits.charAt(sb.length()) - '0';

    	for (char c : KEYS[key].toCharArray()) {
    		sb.append(c);
    		doCombination(sb, digits, res);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    }
}