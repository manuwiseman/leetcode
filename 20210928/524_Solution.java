// class Solution {
//     public String findLongestWord(String s, List<String> dictionary) {
//         Collections.sort(dictionary, (a, b) -> (a.length() != b.length() ? b.length() - a.length() : a.compareTo(b)));
//         for (int i = 0; i < dictionary.size(); i++) {
//             if (isValid(s, dictionary.get(i))) return dictionary.get(i);
//         }
//         return "";
//     }
    
//     private boolean isValid(String src, String target) {
//         int a = 0, b = 0;
//         while (a < src.length() && b < target.length()) {
//             if (src.charAt(a) == target.charAt(b)) {
//                 a++;
//                 b++;
//             } else {
//                 a++;
//             }
//         }
        
//         return b == target.length();
//     }
//  }

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (int i = 0; i < dictionary.size(); i++) {
            int l1 = res.length(), l2 = dictionary.get(i).length();
            if (l1 > l2 || l1 == l2 && res.compareTo(dictionary.get(i)) < 0) {
                continue;
            }
            if (isValid(s, dictionary.get(i))) res = dictionary.get(i);
        }
        return res;
    }
    
    private boolean isValid(String src, String target) {
        int a = 0, b = 0;
        while (a < src.length() && b < target.length()) {
            if (src.charAt(a) == target.charAt(b)) {
                a++;
                b++;
            } else {
                a++;
            }
        }
        
        return b == target.length();
    }
 }