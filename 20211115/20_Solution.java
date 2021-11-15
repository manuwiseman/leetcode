class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                int pop = stack.pop();
                boolean b1 = c == ']' && pop != '[';
                boolean b2 = c == '}' && pop != '{';
                boolean b3 = c == ')' && pop != '(';
                if (b1 || b2 || b3) return false;
            }
        }
        
        return stack.isEmpty();
    }
}