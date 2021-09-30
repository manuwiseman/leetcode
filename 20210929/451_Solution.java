// class Solution {
//     public String frequencySort(String s) {
//         Map<Character, Integer> map = new HashMap<Character, Integer>();
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
        
//         List<Character> list = new ArrayList<Character>(map.keySet());
//         Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        
//         StringBuilder sb = new StringBuilder();
//         for (char c : list) {
//             int count = map.get(c);
//             for (int i = count; i > 0; i--) {
//                 sb.append(c);
//             }
//         }
        
//         return sb.toString();
//     }
// }
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // List<Character> list = new ArrayList<Character>(map.keySet());
        // Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        int max_frequency = Collections.max(map.values());
        List<List<Character>> bucket = new ArrayList<>();
        for (int i = 0; i <= max_frequency; i++) {
            bucket.add(new ArrayList<Character>());
        }
        for (Character key : map.keySet()) {
            int feq = map.get(key);
            bucket.get(feq).add(key);
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.size() - 1; i >= 0; i--) {
            for (char c : bucket.get(i)) {
                for (int count = i; count > 0; count--) {
                    sb.append(c);
                }
            }  
        }
        
        return sb.toString();
    }
}