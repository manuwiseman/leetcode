class Solution {
	private static final HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char[] result = new char[s.length()];
        while (start <= end) {
        	char cStart = s.charAt(start);
        	char cEnd = s.charAt(end);

        	if (!vowels.contains(cStart)) {
        		result[start++] = cStart;
        	} else if (!vowels.contains(cEnd)) {
        		result[end--] = cEnd;
        	} else {
        		result[start++] = cEnd;
        		result[end--] = cStart;
        	}
        }

        return new String(result);
    }
}