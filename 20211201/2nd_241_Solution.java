class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression, 0, expression.length() - 1);
    }

    private List<Integer> dfs(String expression, int start, int end) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = start; i <= end; i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                List<Integer> left = dfs(expression, start, i - 1);
                List<Integer> right = dfs(expression, i + 1, end);
                for (int l : left) {
                    for (int r : right) {
                        list.add(calculate(c, l, r));
                    }
                }
            }
        }
        if (list.isEmpty()) {
            list.add(Integer.parseInt(expression.substring(start, end + 1)));
        }
        return list;
    }

    private int calculate(char c, int l, int r) {
        switch (c) {
            case '+' : return l + r;
            case '-' : return l - r;
            case '*' : return l * r;
            default : break;
        }
        return -1;
    }
}