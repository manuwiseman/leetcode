class MapSum {
	Map<String, Integer> map;
	TrieNode root;

    public MapSum() {
        map = new HashMap<String, Integer>();
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
        	node.children.putIfAbsent(c, new TrieNode());
        	node = node.children.get(c);
        	node.score += delta;
        }
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
        	node = node.children.get(c);
        	if (node == null) return 0;
        }
        return node.score;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

class TrieNode {
	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	int score;
}