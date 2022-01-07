// 1. use stack to store the idx of '(', and when we see ')' we pop
// 2. use a stringbuilder to keep adding character
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(c);
                stack.push(sb.length() - 1);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        
        return sb.toString();
    }
}