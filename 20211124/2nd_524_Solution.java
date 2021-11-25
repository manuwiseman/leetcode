class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (int i = 0; i < dictionary.size(); i++) {
            String target = dictionary.get(i);
            int l1 = res.length(), l2 = target.length();
            if (l1 > l2 || l1 == l2 && res.compareTo(target) < 0) {
                continue;
            }
            if (isValid(s, target)) res = target;
        }
        return res;
    }
    
    private boolean isValid(String s, String target) {
        int a = 0, b = 0;
        while (a < s.length() && b < target.length()) {
            if (s.charAt(a) == target.charAt(b)) {
                a++;
                b++;
            } else {
                a++;
            }
        }
        return b == target.length();
    }
}