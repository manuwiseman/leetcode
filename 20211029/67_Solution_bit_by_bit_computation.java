class Solution {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        // so we only handle when m >= n
        if (m < n) return addBinary(b, a);
        StringBuilder sb = new StringBuilder();
        int j = n - 1, carry = 0;
        
        for(int i = m - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') carry++;
            if (j >= 0 && b.charAt(j--) == '1') carry++;
            sb.append(carry % 2);
            carry /= 2;
        }
        
        if (carry > 0) sb.append('1');
        return sb.reverse().toString();
    }
}