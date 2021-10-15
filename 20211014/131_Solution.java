class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(res, s, new ArrayList<String>());
        return res;
    }

    private void backtracking(List<List<String>> res, String s, List<String> list) {
    	if (s.length() == 0) {
    		res.add(new ArrayList<String>(list));
    	}

    	for(int i = 0; i < s.length(); i++) {
    		if (isPalindrome(s, 0 , i)) {
    			list.add(s.substring(0, i + 1));
    			backtracking(res, s.substring(i + 1), list);
    			list.remove(list.size() - 1);
    		}
    	}
    }

    private boolean isPalindrome(String s, int start, int end) {
    	while (start < end) {
    		if (s.charAt(start++) != s.charAt(end--)) return false;
    	}
    	return true;
    }
}