// ((( - > ()()() / ((())) / 
class Solution {
    public int minAddToMakeValid(String s) {
        // open stores open parentheses possibly can be completed by close parentheses
        // close stores close parentheses that we have to add open parentheses to complete
        int open = 0, close = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;    
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        return open + close;
    }
}