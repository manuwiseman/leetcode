// integer range: -2,147,483,647 to 2,147,483,647, so at most we will see billion in the final string
// 123 -> Three -> Twenty Three -> One Hundred Twenty Three
class Solution {
    String[] Singles = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] Teens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] Doubles = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        // handle the part that's greater than 1 billion
        if (num / (int)1e9 > 0) {
            constructString(sb, num / (int)1e9);
            sb.append("Billion ");
            num -= (num / (int)1e9) * (int)1e9;
        }
        // handle the part that's greater than 1 million
        if (num / (int) 1e6 > 0) {
            constructString(sb, num / (int)1e6);
            sb.append("Million ");
            num -= (num / (int)1e6) * (int)1e6;
        }
        // handle the part that's greater than 1 thousand
        if (num / 1000 > 0) {
            constructString(sb, num / 1000);
            sb.append("Thousand ");
            num -= (num / 1000) * 1000;
        }
        // // handle the part that's less than 1 thousand
        if (num > 0) constructString(sb, num);
        return sb.toString().trim();
    }
    
    private void constructString(StringBuilder sb, int num) {
        // 
        if (num >= 100) {
            sb.append(Singles[num / 100] + " Hundred ");
            num -= (num / 100) * 100;
        }
        if (num >= 20) {
            sb.append(Doubles[num / 10] + " ");
            num -= (num / 10) * 10;
        }
        if (num >= 10 && num < 20) {
            sb.append(Teens[num % 10] + " ");
            return;
        }
        if (num > 0 && num < 10) {
            sb.append(Singles[num] + " ");
            return;
        }
    }
}