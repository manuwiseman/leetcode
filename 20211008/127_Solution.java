class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        Map<String, List<String>> dictionary = new HashMap<>();
        for (String word : wordList) {
        	for (int i = 0; i < L; i++) {
        		String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
        		List<String> matchList = dictionary.getOrDefault(newWord, new ArrayList<String>());
        		matchList.add(word);
        		dictionary.put(newWord, matchList);
        	}
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
        	Pair<String, Integer> pair = queue.poll();
        	String w = pair.getKey();
        	int level = pair.getValue();

        	for (int i = 0; i < L; i++) {
        		String nw = w.substring(0, i) + "*" + w.substring(i + 1);
        		for (String dic : dictionary.getOrDefault(nw, new ArrayList<String>())) {
        			if (dic.equals(endWord)) return level + 1;
        			if (!visited.containsKey(dic)) {
        				visited.put(dic, true);
        				queue.add(new Pair(dic, level + 1));
        			}
        		}
        	}
        }
        return 0;
    }
}