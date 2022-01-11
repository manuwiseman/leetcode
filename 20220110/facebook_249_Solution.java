class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        // all shifted string that can be map to same key should be store together
        // 1. have a hashmap, key is unique identifier, value is a list of strings mapped to this key
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strings) {
            String key = getKey(s);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    
    private String getKey(String s) {
        StringBuilder sb = new StringBuilder();
        char first = s.charAt(0);
        for (char c : s.toCharArray()) {
            char x = (c - first > 0) ? (char)(c - first) : (char)(c - first + 26);
            sb.append(x);
        }
        return sb.toString();
    }
}