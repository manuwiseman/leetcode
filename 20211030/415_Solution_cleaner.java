class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (m >= 0 || n >= 0 || carry > 0) {
            int x = m >= 0 ? num1.charAt(m--) - '0' : 0;
            int y = n >= 0 ? num2.charAt(n--) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        
        return sb.reverse().toString();
    }
}