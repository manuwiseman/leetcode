class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. rearragen each string and make each letter in lexicographic order
        // e.g. ate -> aet
        // 2. have a hashmap that link this reordered key to the original word
        // e.g. aet -> ate, eat, tea
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            String key = getKey(s);
            List<String> matchingStrings = map.getOrDefault(key, new ArrayList<String>());
            matchingStrings.add(s);
            map.put(key, matchingStrings);
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        // 3. we iterate the values of map and insert them into the final list
        for (List<String> value : map.values()) {
            ans.add(new ArrayList<String>(value));
        }
        
        return ans;
    }
    
    // rearrange the letters in string in lexicographic order
    private String getKey(String s) {
        if (s.isEmpty() || s.length() <= 1) return s;
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }
}