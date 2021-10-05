class Solution {
    public List<Integer> diffWaysToCompute(String input) {
    	return dfs(input, 0, input.length() - 1);
    }

    private List<Integer> dfs(String input, int start, int end) {
    	List<Integer> list = new ArrayList<Integer>();
    	for (int i = start; i <= end; i++) {
    		char c = input.charAt(i);
    		if (!Character.isDigit(c)) {
    			List<Integer> left = dfs(input, start, i - 1);
    			List<Integer> right = dfs(input, i + 1, end);
    			for (int l : left) {
    				for (int r : right) {
    					list.add(calculate(c, l, r));
    				}
    			}
    		}
    	}

    	if (list.isEmpty()) {
    		list.add(Integer.parseInt(input.substring(start, end + 1)));
    	}
    	return list;
    }

    private int calculate(char c, int a, int b) {
    	switch (c) {
    		case '*' :
    			return a * b;
    		case '+' :
    			return a + b;
    		case '-' :
    			return a - b;
    		default :
    			break;
    	}
    	return -1;
    }
}