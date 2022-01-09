class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int pointW = 0, pointA = 0;
        while (pointW < word.length() && pointA < abbr.length()) {
            if (word.charAt(pointW) == abbr.charAt(pointA)) {
                pointW++;
                pointA++;
                continue;
            }
            if (abbr.charAt(pointA) <= '0' || abbr.charAt(pointA) > '9') return false;
            
            int start = pointA;
            while (pointA < abbr.length() && abbr.charAt(pointA) >= '0' && abbr.charAt(pointA) <= '9') {
                pointA++;
            }
            pointW += Integer.parseInt(abbr.substring(start, pointA));
        }
        
        return pointW == word.length() && pointA == abbr.length();
    }
}