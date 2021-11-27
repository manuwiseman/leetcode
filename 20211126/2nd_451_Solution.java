class Solution {
    public String frequencySort(String s) {
        // build a map of occurrences of each character
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // find the max value of occurence
        int max_occur = Collections.max(map.values());
        
        // create a list whose index is the count
        // and values being the characters who has this count
        List<List<Character>> list = new ArrayList<List<Character>>(max_occur + 1);
        for (int i = 0; i <= max_occur; i++) {
            list.add(new ArrayList<Character>());
        }
        
        for (char key: map.keySet()) {
            list.get(map.get(key)).add(key);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i > 0; i--) {
            for (char c : list.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}