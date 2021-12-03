class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        // construct the dictionary map that contains wild card string as key and
        // list of strings that matches wild card as value
        Map<String, List<String>> dictionary = new HashMap<String, List<String>>();
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String nw = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> matchingStrings = dictionary.getOrDefault(nw, new ArrayList<String>());
                matchingStrings.add(word);
                dictionary.put(nw, matchingStrings);
            }
        }
        
        Queue<Pair<String, Integer>> q = new LinkedList<Pair<String, Integer>>();
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        q.add(new Pair<String, Integer>(beginWord, 1));
        visited.put(beginWord, true);
        while (!q.isEmpty()) {
            Pair<String, Integer> pair = q.poll();
            String w = pair.getKey();
            int level = pair.getValue();
            
            for (int i = 0; i < L; i++) {
                String nw = w.substring(0, i) + "*" + w.substring(i + 1);
                for (String dic : dictionary.getOrDefault(nw, new ArrayList<String>())) {
                    if (dic.equals(endWord)) return level + 1;
                    if (!visited.containsKey(dic)) {
                        q.add(new Pair<String, Integer>(dic, level + 1));
                        visited.put(dic, true);
                    }
                }
            }
        }
        return 0;
    }
}