class Solution {
    private final static Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    
    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char[] result = new char[s.length()];
        while (start <= end) {
            char cs = s.charAt(start);
            char ce = s.charAt(end);
            if (!vowels.contains(cs)) result[start++] = cs;
            else if (!vowels.contains(ce)) result[end--] = ce;
            else {
                result[start++] = ce;
                result[end--] = cs;
            } 
        }
        
        return new String(result);
    }
}