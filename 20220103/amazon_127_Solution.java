// hit -> *it, h*t, hi*
// in wordList we can find the wildcard and create map, then from the beginWord we can start finding the wildcards and check each word associate with the wildcard, and ge the shortest path
// so this is a BFS problem
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        // create a map, key -> string wildcard, value -> list of matching strings
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String nw = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = map.getOrDefault(nw, new ArrayList<String>());
                list.add(word);
                map.put(nw, list);
            }
        }
        
        Queue<Pair<String, Integer>> q = new LinkedList<Pair<String, Integer>>();
        Set<String> visited = new HashSet<String>();
        q.add(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            Pair<String, Integer> pair = q.poll();
            String s = pair.getKey();
            int level = pair.getValue();
            visited.add(s);
            for (int i = 0; i < L; i++) {
                String nw = s.substring(0, i) + "*" + s.substring(i + 1);
                for (String candidate : map.getOrDefault(nw, new ArrayList<String>())) {
                    if (candidate.equals(endWord)) return level + 1;
                    if (!visited.contains(candidate)) {
                        q.add(new Pair(candidate, level + 1));
                        visited.add(candidate);
                    }
                }
            }  
        }
        return 0; 
    }
}