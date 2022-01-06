class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. Hashmap that link all the words with anagrams into same key
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        // 2. find the key that links all the words and populate the hashmap
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            // option 1. sort the array -> time complexity : N*K*Log(K)
            // option 2: int[26] -> time complexity: N*K
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
                sb.append("#");
            }
            String key = sb.toString();
            List<String> matchingStrings = map.getOrDefault(key, new ArrayList<String>());
            matchingStrings.add(s);
            map.put(key, matchingStrings);
        }
        // 3. return a list of map's value, and that's the result
        return new ArrayList<List<String>>(map.values());  
    }
}