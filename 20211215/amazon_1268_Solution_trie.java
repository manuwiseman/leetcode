class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>>  ans = new ArrayList<List<String>> ();
        for (String p : products) {
        	trie.insert(p);
        }
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
        	prefix += c;
        	ans.add(trie.getWordsStartingWith(prefix));
        }
        return ans;
    }
}

class Trie {
	class Node {
		boolean isWord = false;
		List<Node> children = Arrays.asList(new Node[26]);
	}
	Node root, cur;
	List<String> resultBuffer;
    
    public Trie() {
        root = new Node();
    }

	public void insert(String s) {
		cur = root;
		for(char c : s.toCharArray()) {
			if (cur.children.get(c - 'a') == null) {
				cur.children.set(c - 'a', new Node());
			}
			cur = cur.children.get(c - 'a');
		}
		cur.isWord = true;
	}

	public List<String> getWordsStartingWith(String prefix) {
		cur = root;
		resultBuffer = new ArrayList<String>();
		for (char c : prefix.toCharArray()) {
			if (cur.children.get(c - 'a') == null) return resultBuffer;
			cur = cur.children.get(c - 'a'); 
		}
		dfs(cur, prefix);
		return resultBuffer;
	}

	private void dfs(Node cur, String word) {
		if (resultBuffer.size() == 3) return;
		if (cur.isWord) resultBuffer.add(word);
		for (char c = 'a'; c <= 'z'; c++) {
			if (cur.children.get(c - 'a') != null) {
                dfs(cur.children.get(c - 'a'), word + c);
            }
		}
	}

}