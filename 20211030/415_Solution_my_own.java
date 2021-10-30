class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if (m < n) return addStrings(num2, num1);
        StringBuilder sb = new StringBuilder();
        int carry = 0, j = n - 1;
        
        for (int i = m - 1; i >= 0; i--) {  
            carry += j >= 0 ? num1.charAt(i) - '0' + num2.charAt(j) - '0' : num1.charAt(i) - '0';
            j--;
            sb.append(carry % 10);
            carry /= 10;
        }
        
        if (carry > 0) sb.append('1');
        
        return sb.reverse().toString();
    }
}