// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         int indexS = 0, indexT = 0;
//         while (indexS < s.length() && indexT < t.length()) {
//             if (s.charAt(indexS) == t.charAt(indexT)) {
//                 indexS++;
//             }
//             indexT++;
//         }
//         return indexS == s.length();
//     }
// }

class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }
}