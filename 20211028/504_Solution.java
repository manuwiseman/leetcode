class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int abs = Math.abs(num);
        
        while (abs > 0) {
            sb.append(abs % 7);
            abs /= 7;
        }
        if (num < 0) {
            sb.append('-');
        }
        
        return sb.reverse().toString();
    }
}