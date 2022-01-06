/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// s = "2-3/(5*2)+1"
// 1. I want to use a stack to store the char we have processed and pop it if needed
// 2. if it's digit we just push into stack
// 3. if it's '*' or '/', we need to check if the previous operator in stack if also '*' or '/', because e.g. 2 + 3 * 5, we have to calcualte the 3 * 5 first
// 4. if it's '+' or '-', we need to go all the way back until we see '(', cuz e.g. 2 + 3 * 5 + 4, for the 2nd '+', after we done with 3 * 5, we still have to do 2 + result_of_(3 * 5). And the ending point is we hit '(', so we have to put the whole string into ()
class Solution {
    public Node expTree(String s) {
        // we put () around whole string because we only stop at '('
        s = '(' + s + ')';
        Stack<Node> stack = new Stack<Node>();
        for (char c : s.toCharArray()) {
            // check #3 and #4
            if (!Character.isDigit(c) && c != '(') {
                // right is the digit on the right side of previous opeator
                Node right = stack.pop();
                // if it's '*' or '/', we need to check if the previous operator 
                // in stack if also '*' or '/', because e.g. 2 + 3 * 5, we have to 
                // calcualte the 3 * 5 first
                if (c == '*' || c == '/') {
                    if (stack.peek().val == '*' || stack.peek().val == '/') {
                        Node operator = stack.pop();
                        Node left = stack.pop();
                        operator.left = left;
                        operator.right = right;
                        right = operator;
                    }
                } 
                // if it's '+' or '-' or ')', we need to go all the way back 
                // until we see '(', cuz e.g. (2 + 3 * 5 + 4), for the 2nd '+', 
                // after we done with 3 * 5, we still have to do 2 + 15
                else {
                    while (stack.peek().val != '(') {
                        Node operator = stack.pop();
                        Node left = stack.pop();
                        operator.left = left;
                        operator.right = right;
                        right = operator;
                    }
                    // pop out the '(' once we process ')'
                    if (c == ')') {
                        stack.pop();
                    }
                }
                stack.push(right);
            }
            // we never insert ')' into stack
            if (c != ')') {
                stack.push(new Node(c));
            }
        }
        return stack.pop();
    }
}