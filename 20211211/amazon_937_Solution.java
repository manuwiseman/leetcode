class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];
        PriorityQueue<String> letters = new PriorityQueue<String>(new LetterLogComparator());
        List<String> digits = new ArrayList<String>();
        
        for (String log : logs) {
            char c = log.charAt(log.indexOf(" ") + 1);
            if (Character.isDigit(c)) {
                digits.add(log);
            } else {
                letters.add(log);
            }  
        }
        
        int idx = 0;
        while (!letters.isEmpty()) {
            res[idx++] = letters.poll();
        }
        for (int i = 0; i < digits.size(); i++) {
            res[idx++] = digits.get(i);
        }
        
        return res;
    }
}

class LetterLogComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2) {
        String[] strs1 = s1.split(" ", 2);
        String[] strs2 = s2.split(" ", 2);
        if (strs1[1].equals(strs2[1])) return strs1[0].compareTo(strs2[0]);
        else return strs1[1].compareTo(strs2[1]);
    }
}