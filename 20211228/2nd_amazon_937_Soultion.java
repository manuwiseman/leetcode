class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length]; 
        // 1. create pq to sort letter string lexicographically and create list to sort digit string by their original order
        PriorityQueue<String> letters = new PriorityQueue<String>(new LetterLogComparator());
        List<String> digits = new ArrayList<String>();
        
        // 2. process string array, insert each string either into letters pq or digits list
        for (String log : logs) {
            char c = log.substring(log.indexOf(" ") + 1).charAt(0);
            if (Character.isDigit(c)) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }
        
        // 3. move elements in letters and digits into ans array
        int index = 0;
        while (!letters.isEmpty()) {
            ans[index++] = letters.poll();
        }
        for (String d : digits) {
            ans[index++] = d;
        }
        
        return ans;
    }
}

class LetterLogComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String[] s1Array = s1.split(" ", 2);
        String[] s2Array = s2.split(" ", 2);
        return s1Array[1].equals(s2Array[1]) ? 
            s1Array[0].compareTo(s2Array[0]) : s1Array[1].compareTo(s2Array[1]);
    }
}